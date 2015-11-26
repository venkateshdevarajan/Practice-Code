package CodeReview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Venkatesh
 */
public class Solution_1 {

  public static void main(String[] args) throws IOException {
    List<String> input = readInputFromConsole();

    Prism begin = convertInputToPrisms(input);
    if (begin == null) {
      return;
    }

    Prism beginNext = begin.getNext();
    begin.setNext(null);

    long distance = getDistanceTravelled(begin, beginNext);
    // Print the final result.
    System.out.println(distance);
  }

  private static List<String> readInputFromConsole() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<String> input = new LinkedList<String>();
    String currentLine = br.readLine();
    do {
      currentLine = currentLine.trim();
      if (currentLine.length() == 0)
        break;

      input.add(currentLine);
    } while ((currentLine = br.readLine()) != null);
    return input;
  }

  /*
   * Pre-processing the input. Validating the given input. Calculating total number of rows and columns. Creating prism
   * objects for the given input.(setting row, column and direction) Setting the next reference for the actual
   * prisms(v,<,>,^).
   * @return Prism (Position of the laser beam '@')
   */
  private static Prism convertInputToPrisms(List<String> input) {
    int noOfRows = input.size();
    int noOfColumns = input.get(0).length();

    Prism begin = null;
    // Previous prism in the same column
    Prism[] prevPrismsInColumns = new Prism[noOfColumns];
    // Next destination
    Prism beginNext = null;

    int currentRowNumber = 0;
    for (String line : input) {
      // Previous prism
      Prism previous = null;
      currentRowNumber++;
      // Iterate through each character in current line
      for (int i = 0; i < noOfColumns; i++) {
        final char ch = line.charAt(i);

        Prism currentPrism = new Prism();
        currentPrism.setRow(currentRowNumber - 1);
        currentPrism.setColumn(i);

        Direction prismType = Direction.get(ch);
        if (prismType != null) {
          prismType.populatePrism(prevPrismsInColumns, previous, currentPrism, noOfRows, noOfColumns);
        } else {
          if ('@' == ch) {
            begin = currentPrism;
            currentPrism.setDirection(Direction.EAST);
            currentPrism.setDistanceBetweenWallAndPrism(noOfColumns - currentPrism.getColumn());
          }
          continue;
        }

        if (begin != null && beginNext == null && begin.getRow() == currentPrism.getRow()) {
          beginNext = currentPrism;
          begin.setNext(beginNext);
          // nextPrism.getColumn() - currentPrism.getColumn()
          begin.setDistanceBetweenPrisms(beginNext.getColumn() - begin.getColumn());
        }

        prevPrismsInColumns[i] = currentPrism;
        previous = currentPrism;
      }
    }
    return begin;
  }

  private static long getDistanceTravelled(Prism begin, Prism beginNext) {
    Prism currentPrism = null;
    long distance = 0;

    if (begin != null) {
      if (beginNext != null) {
        distance += begin.getDistanceBetweenPrisms();
        currentPrism = beginNext;
      } else {
        distance += begin.getDistanceBetweenWallAndPrism();
      }
    }

    // Iterate through all the prisms and compute the distance.
    while (currentPrism != null) {
      // Set the distance to -1 if the prism is already visited.
      if (currentPrism.isVisited()) {
        distance = -1;
        break;
      }

      currentPrism.setVisited(true);
      Prism next = currentPrism.getNext();

      if (next == null) {
        distance += currentPrism.getDistanceBetweenWallAndPrism();
        break;
      }
      distance += currentPrism.getDistanceBetweenPrisms();
      currentPrism = next;
    }
    return distance;
  }
}

/**
 * Enum to store the directions. We can extend it if we need to add new directions.
 * 
 * @author Venkatesh
 */
enum Direction {

  EAST('>') {
    @Override
    public void populatePrism(Prism[] prevPrismsInColumns, Prism previousPrismInTheRow, Prism currentPrism,
        int noOfRows, int noOfColumns) {
      currentPrism.setDirection(Direction.EAST);
      currentPrism.setDistanceBetweenWallAndPrism(noOfColumns - currentPrism.getColumn());

      super.populatePrism(prevPrismsInColumns, previousPrismInTheRow, currentPrism, noOfRows, noOfColumns);
    }
  },
  NORTH('^') {
    @Override
    public void populatePrism(Prism[] prevPrismsInColumns, Prism previousPrismInTheRow, Prism currentPrism,
        int noOfRows, int noOfColumns) {
      currentPrism.setDirection(Direction.NORTH);
      currentPrism.setDistanceBetweenWallAndPrism(currentPrism.getRow() + 1);
      Prism prevRowPrism = prevPrismsInColumns[currentPrism.getColumn()];
      if (prevRowPrism != null) {
        // currentPrism.getRow() - nextPrism.getRow()
        currentPrism.setDistanceBetweenPrisms(currentPrism.getRow() - prevRowPrism.getRow());
        currentPrism.setNext(prevRowPrism);
      }

      super.populatePrism(prevPrismsInColumns, previousPrismInTheRow, currentPrism, noOfRows, noOfColumns);
    }
  },
  SOUTH('v') {
    @Override
    public void populatePrism(Prism[] prevPrismsInColumns, Prism previousPrismInTheRow, Prism currentPrism,
        int noOfRows, int noOfColumns) {
      currentPrism.setDirection(Direction.SOUTH);
      currentPrism.setDistanceBetweenWallAndPrism(noOfRows - currentPrism.getRow());

      super.populatePrism(prevPrismsInColumns, previousPrismInTheRow, currentPrism, noOfRows, noOfColumns);
    }
  },
  WEST('<') {
    @Override
    public void populatePrism(Prism[] prevPrismsInColumns, Prism previousPrismInTheRow, Prism currentPrism,
        int noOfRows, int noOfColumns) {
      currentPrism.setDirection(Direction.WEST);
      currentPrism.setDistanceBetweenWallAndPrism(currentPrism.getColumn() + 1);
      if (previousPrismInTheRow != null) {
        // currentPrism.getColumn() - nextPrism.getColumn();
        currentPrism.setDistanceBetweenPrisms(currentPrism.getColumn() - previousPrismInTheRow.getColumn());
        currentPrism.setNext(previousPrismInTheRow);
      }

      super.populatePrism(prevPrismsInColumns, previousPrismInTheRow, currentPrism, noOfRows, noOfColumns);
    }
  };

  private final char symbol;

  Direction(char symbol) {
    this.symbol = symbol;
  }

  public void populatePrism(Prism[] prevPrismsInColumns, Prism previousPrismInTheRow, Prism currentPrism, int noOfRows,
      int noOfColumns) {
    if (previousPrismInTheRow != null && Direction.EAST.equals(previousPrismInTheRow.getDirection())) {
      // nextPrism.getColumn() - currentPrism.getColumn()
      previousPrismInTheRow.setDistanceBetweenPrisms(currentPrism.getColumn() - previousPrismInTheRow.getColumn());
      previousPrismInTheRow.setNext(currentPrism);
    }

    Prism prevRowPrism = prevPrismsInColumns[currentPrism.getColumn()];
    if (prevRowPrism != null && Direction.SOUTH.equals(prevRowPrism.getDirection())) {
      // nextPrism.getRow() - currentPrism.getRow();
      prevRowPrism.setDistanceBetweenPrisms(currentPrism.getRow() - prevRowPrism.getRow());
      prevRowPrism.setNext(currentPrism);
    }

  }

  public static Direction get(char symbol) {
    for (Direction direction : values()) {
      if (direction.symbol == symbol) {
        return direction;
      }
    }
    return null;
  }

}

/**
 * Class to maintain the prism details.
 * 
 * @author Venkatesh
 */
final class Prism {

  private int row;

  private int column;

  private int distanceBetweenPrisms;

  private int distanceBetweenWallAndPrism;

  private Direction direction;

  // To keep track whether prism has been visited already
  private boolean visited;

  // Points to next prism.
  private Prism next;

  // Getter/Setters for all private variables.

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getColumn() {
    return column;
  }

  public void setColumn(int column) {
    this.column = column;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  /**
   * Return the next prism, if the laser hits a prism. Else this will return null.
   * 
   * @return
   */
  public Prism getNext() {
    return next;
  }

  public void setNext(Prism next) {
    this.next = next;
  }

  public int getDistanceBetweenPrisms() {
    return distanceBetweenPrisms;
  }

  public void setDistanceBetweenPrisms(int distanceBetweenPrisms) {
    this.distanceBetweenPrisms = distanceBetweenPrisms;
  }

  public int getDistanceBetweenWallAndPrism() {
    return distanceBetweenWallAndPrism;
  }

  public void setDistanceBetweenWallAndPrism(int distanceBetweenWallAndPrism) {
    this.distanceBetweenWallAndPrism = distanceBetweenWallAndPrism;
  }
}
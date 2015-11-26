package Old.CodeReview;

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


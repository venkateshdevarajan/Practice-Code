package CodeReview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author venkateshd
 * 
 */
public class SolutionNew {

  private int noOfRows;
  private int noOfColumns;
  private Coordinates laserBeginPosition;
  private Map<Character, Coordinates> prismsVsDeflectingIndex = new HashMap<Character, Coordinates>();
  private Set<Coordinates> visitedPrisms = new HashSet<Coordinates>();

  public static void main(String[] args) throws IOException {
    SolutionNew solution = new SolutionNew();
    char inputString[][] = solution.readInputFromConsole();
    solution.initializePrismAndDeflectingIndex();
    int distance = solution.getDistanceTravelled(inputString);
    System.out.println(distance);
  }

  private char[][] readInputFromConsole() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[][] ip = new char[50][50];
    int i = 0;
    String currentLine = br.readLine();
    noOfColumns = currentLine.length();
    do {
      currentLine = currentLine.trim();
      if (currentLine.length() == 0)
        break;
      ip[i] = currentLine.toCharArray();
      for (int k = 0; k < ip[i].length; k++) {
        if (ip[i][k] == '@') {
          laserBeginPosition = new Coordinates(i, k);
        }
      }
      i++;
    } while ((currentLine = br.readLine()) != null);
    noOfRows = i;
    return ip;
  }

  private void initializePrismAndDeflectingIndex() {
    prismsVsDeflectingIndex.put('>', new Coordinates(0, 1));
    prismsVsDeflectingIndex.put('v', new Coordinates(1, 0));
    prismsVsDeflectingIndex.put('^', new Coordinates(-1, 0));
    prismsVsDeflectingIndex.put('<', new Coordinates(0, -1));
  }


  /**
 * @param inputString
 * @return distance travelled by the laser beam to reach the wall.
 * 
 * Whenever laser beam reaches any valid prisms(<,>,v,^), the next laser index will be calculated
 * based on the value from prismsVsDeflectingIndex map. 
 */
private int getDistanceTravelled(char[][] inputString) {
    Coordinates currentLaserCoordinates = laserBeginPosition;
    Coordinates numberOfCoordinatesToBeMoved = prismsVsDeflectingIndex.get('>');
    int i = currentLaserCoordinates.getRow();
    int j = currentLaserCoordinates.getColumn();
    int distance = 0;

    while ((i < noOfRows && i >= 0) && (j >= 0 && j < noOfColumns)) {
      if (prismsVsDeflectingIndex.get(inputString[i][j]) != null) {
        numberOfCoordinatesToBeMoved = prismsVsDeflectingIndex.get(inputString[i][j]);
        currentLaserCoordinates = currentLaserCoordinates.add(numberOfCoordinatesToBeMoved);
        // If the direction prism is already visited, there will be a loop and hence the distance is -1.
        if (!visitedPrisms.add(new Coordinates(i, j))) {
          distance = -1;
          break;
        } else {
          distance += 1;
        }
      } else {
        currentLaserCoordinates = currentLaserCoordinates.add(numberOfCoordinatesToBeMoved);
        distance = distance + 1;
      }
      i = currentLaserCoordinates.getRow();
      j = currentLaserCoordinates.getColumn();
    }
    return distance;
  }
}

/**
 * @author Venkatesh
 */
class Coordinates {

  int x; 
  int y; 

  Coordinates(int row, int column) {
    x = row;
    y = column;
  }

  int getRow() {
    return x;
  }

  int getColumn() {
    return y;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + x;
    result = prime * result + y;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Coordinates other = (Coordinates) obj;
    if (x != other.x)
      return false;
    if (y != other.y)
      return false;
    return true;
  }

  public Coordinates add(Coordinates coordinates) {
    return new Coordinates(x + coordinates.getRow(), y + coordinates.getColumn());
  }
}

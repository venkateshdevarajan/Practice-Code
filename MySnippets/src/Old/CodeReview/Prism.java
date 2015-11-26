package Old.CodeReview;

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
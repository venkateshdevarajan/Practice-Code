package Old.CodeReview;

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

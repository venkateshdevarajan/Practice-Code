package Old.CodeReview;

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


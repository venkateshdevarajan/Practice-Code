import java.io.*;

/** 
 * @author Venkatesh
 */
public class LazerMaze {

	//Number of rows in the given laser map
	private static int noOfRows;

	//Number of columns in the given laser map
	private static int noOfColumns;

	/**
	 * Calculate distance between two prisms.
	 * 
	 * @param currentPrism
	 * @param nextPrism
	 * @return distance
	 */
	private static long distBetweenPrisms(final Prism currentPrism, final Prism nextPrism) {
		
		if (Direction.EAST.equals(currentPrism.getDirection()))
			return nextPrism.getColumn() - currentPrism.getColumn();

		if (Direction.WEST.equals(currentPrism.getDirection()))
			return currentPrism.getColumn() - nextPrism.getColumn();

		if (Direction.SOUTH.equals(currentPrism.getDirection()))
			return nextPrism.getRow() - currentPrism.getRow();

		return currentPrism.getRow() - nextPrism.getRow();
	}

	/**
	 * Calculate distance between prism to wall.
	 * @param currentPrism
	 * @return distance
	 */
	private static long distBetweenPrismToWall(final Prism currentPrism) {
		
		if (Direction.EAST.equals(currentPrism.getDirection()))
			return noOfColumns - currentPrism.getColumn();

		if (Direction.WEST.equals(currentPrism.getDirection()))
			return currentPrism.getColumn() + 1;

		if (Direction.SOUTH.equals(currentPrism.getDirection()))
			return noOfRows - currentPrism.getRow();
		
		return currentPrism.getRow() + 1;
	}
	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		//Validating input.
		if(line==null) {
			return;
		}else {
			line =line.trim();
		}
		noOfColumns = line.length();

		//Previous row.
		Prism[] prevRow = new Prism[noOfColumns];

		// Beginning laser point.
		Prism begin = null;

		// Next destination
		Prism beginNext = null;

		noOfRows = 0;

		do {
			line = line.trim();
			if (line.length() == 0)
				break;

			noOfRows++;

			// Previous prism
			Prism previous = null;

			// Iterate through each character in current line
			for (int i = 0; i < noOfColumns; i++) {
				final char ch = line.charAt(i);

				Prism currentPrism = new Prism();
				currentPrism.setRow(noOfRows - 1);
				currentPrism.setColumn(i);

				// Set the direction.
				switch (ch) {
					case 'v':
						currentPrism.setDirection(Direction.SOUTH);
						break;
	
					case '>':
						currentPrism.setDirection(Direction.EAST);
						break;
	
					case '<':
						currentPrism.setDirection(Direction.WEST);
						if (previous != null) {
							currentPrism.setNext(previous);
						}
						break;
					//North direction
					case '^': 
						currentPrism.setDirection(Direction.NORTH);
						Prism prevRowPrism = prevRow[i];
						if (prevRowPrism != null) {
							currentPrism.setNext (prevRowPrism);
						}
						break;
					//Laser's position in the room
					case '@':
						begin = currentPrism;
						currentPrism.setDirection(Direction.EAST);
						
					case '-':
						continue;
				}

				if (begin != null && beginNext == null && begin.getRow() == currentPrism.getRow())
					beginNext = currentPrism;

				if (previous != null && Direction.EAST.equals(previous.getDirection())) {
					previous.setNext (currentPrism);
				}

				Prism prevRowPrism = prevRow[i];
				if (prevRowPrism != null
						&& Direction.SOUTH.equals(prevRowPrism.getDirection())) {
					prevRowPrism.setNext(currentPrism);
				}

				prevRow[i] = currentPrism;
				previous = currentPrism;
			}
		} while ((line = br.readLine()) != null);

		Prism currentPrism = null;

		// Sum of total distance
		long distance = 0;

		if (begin != null) {
			if (beginNext != null) {
				distance += distBetweenPrisms(begin, beginNext);
				currentPrism = beginNext;
			} else {
				distance += distBetweenPrismToWall(begin);
			}
		}

		// Iterate through all the prisms and compute the distance.
		while (currentPrism != null) {
			//Reset the distance if its already visited 
			if (currentPrism.isVisited()) {
				distance = -1;
				break;
			}

			currentPrism.setVisited(true);
			Prism next = currentPrism.getNext();

			if (next == null) {
				distance += distBetweenPrismToWall(currentPrism);
				break;
			}

			distance += distBetweenPrisms(currentPrism, next);
			currentPrism = next;
		}
		//Print the final result.
		System.out.println(distance);
	}
}

/**
 * Enum to store the directions. We can extend it if we need to add new directions.
 * @author Venkatesh 
 */
enum Direction {
	EAST, NORTH, SOUTH, WEST;
}

/**
 * Class to maintain the prism details. 
 * @author Venkatesh
 */
final class Prism {
	
	private int row;
	private int column;

	private Direction direction;

	//To keep track whether prism has been visited already
	private boolean visited;

	//Points to next prism.
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
	 * @return
	 */
	public Prism getNext() {
		return next;
	}

	public void setNext(Prism next) {
		this.next = next;
	}
}

package Old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Venkatesh
 */
public class Solution1 {

	// Number of rows in the given laser map
	private static int noOfRows;

	// Number of columns in the given laser map
	private static int noOfColumns;	

	
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
	 * Pre-processing the input.
	 * 
	 * Validating the given input. Calculating total number of rows and columns.
	 * Creating prism objects for the given input.(setting row, column and
	 * direction) Setting the next reference for the actual prisms(v,<,>,^).
	 * 
	 * @return Prism (Position of the laser beam '@')
	 */
	private static Prism convertInputToPrisms(List<String> input)
			throws IOException {
		noOfRows = input.size();
		noOfColumns = input.get(0).length();

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

				// Set the direction.
				switch (ch) {
				case 'v':
					currentPrism.setDirection(Direction.SOUTH);
					currentPrism.setDistanceBetweenWallAndPrism(noOfRows
							- currentPrism.getRow());
					break;

				case '>':
					currentPrism.setDirection(Direction.EAST);
					currentPrism.setDistanceBetweenWallAndPrism(noOfColumns
							- currentPrism.getColumn());
					break;

				case '<':
					currentPrism.setDirection(Direction.WEST);
					currentPrism.setDistanceBetweenWallAndPrism(currentPrism
							.getColumn() + 1);
					if (previous != null) {
						// currentPrism.getColumn() - nextPrism.getColumn();
						currentPrism.setDistanceBetweenPrisms(currentPrism
								.getColumn() - previous.getColumn());
						currentPrism.setNext(previous);
					}
					break;
				// North direction
				case '^':
					currentPrism.setDirection(Direction.NORTH);
					currentPrism.setDistanceBetweenWallAndPrism(currentPrism
							.getRow() + 1);
					Prism prevRowPrism = prevPrismsInColumns[i];
					if (prevRowPrism != null) {
						// currentPrism.getRow() - nextPrism.getRow()
						currentPrism.setDistanceBetweenPrisms(currentPrism
								.getRow() - prevRowPrism.getRow());
						currentPrism.setNext(prevRowPrism);
					}
					break;
				// Laser's position in the room
				case '@':
					begin = currentPrism;
					currentPrism.setDirection(Direction.EAST);
					currentPrism.setDistanceBetweenWallAndPrism(noOfColumns
							- currentPrism.getColumn());
				case '-':
					continue;
				}

				if (begin != null && beginNext == null
						&& begin.getRow() == currentPrism.getRow()) {
					beginNext = currentPrism;
					begin.setNext(beginNext);
					// nextPrism.getColumn() - currentPrism.getColumn()
					begin.setDistanceBetweenPrisms(beginNext.getColumn()
							- begin.getColumn());
				}

				if (previous != null
						&& Direction.EAST.equals(previous.getDirection())) {
					// nextPrism.getColumn() - currentPrism.getColumn()
					previous.setDistanceBetweenPrisms(currentPrism.getColumn()
							- previous.getColumn());
					previous.setNext(currentPrism);
				}

				Prism prevRowPrism = prevPrismsInColumns[i];
				if (prevRowPrism != null
						&& Direction.SOUTH.equals(prevRowPrism.getDirection())) {
					// nextPrism.getRow() - currentPrism.getRow();
					prevRowPrism.setDistanceBetweenPrisms(currentPrism.getRow()
							- prevRowPrism.getRow());
					prevRowPrism.setNext(currentPrism);
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


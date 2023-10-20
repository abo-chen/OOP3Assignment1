import java.util.Comparator;

import shape.Shape3D;
import utility.CommandLineParser;
import utility.ShapesReader;
import utility.SortingUtility;


/**
 * Sorts an array of 3D shapes based on user-specified criteria.
 * <p>
 * This program takes in command line arguments to specify the name of the file containing shape data, 
 * the type of sort, and the property of the shape to be compared (e.g. height, volume, area.). It then 
 * reads the shapes from the file, sorts them based on the specified criteria, and prints out the time 
 * taken to perform the sort.
 * </p>
 */
public class Sort {
	
	/**
	 * Entry point for the sorting program.
	 *
	 * @param args command line arguments specifying the file name, sort type, and compare type.
	 */
	public static void main(String[] args) {

		CommandLineParser parser = new CommandLineParser();
		if (parser.parseArgs(args)) {
			System.out.print("File Name: " + parser.getFileName());
			System.out.print(", Sort Type: " + parser.getSortType());
			System.out.println(", Compare Type: " + parser.getCompareType() + ".");
		} else {
			parser.showHelp();
		}

		Shape3D[] shapes;
		// Load shapes from the specified file
		try {
			shapes = ShapesReader.readShapesFromLargeFile(parser.getFileName());
			System.out.println("Shapes loaded: " + shapes.length + ".");

		} catch (Exception e) { // Invalid file name.
			System.out.println("Error reading from file: " + parser.getFileName());
			return;
		}

		System.out.print("Start Sorting ... ");
		// Getting the start time
		long startTime = System.nanoTime();

		Comparator<Shape3D> comparator;
		// Validate and set CompareType
		try {
			comparator = Shape3D.CompareType.getComparator(Shape3D.CompareType.fromString(parser.getCompareType()));
		} catch (Exception e) { // Invalid file name.
			System.out.println("Invalid compare type: " + parser.getCompareType());
			return;
		}

		// Sort shapes using the specified comparator
		SortingUtility.Sort(parser.getSortType(), shapes, comparator);

		// Get end time
		long endTime = System.nanoTime();
		// Calculate and output the time required
		long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds

		// Display the time taken for sorting
		System.out.println("Sorting took: " + duration + " milliseconds.");

	}
}

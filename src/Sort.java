import java.util.Comparator;

import shape.Shape3D;
import utility.CommandLineParser;
import utility.ShapesReader;
import utility.SortingUtility;

public class Sort {
	public static void main(String[] args) {

		CommandLineParser parser = new CommandLineParser();
		if (parser.parseArgs(args)) {
			System.out.print("File Name: " + parser.getFileName());
			System.out.print(", Sort Type: " + parser.getSortType());
			System.out.println(", Compare Type: " + parser.getCompareType() + ".");
			// Further processing based on the inputs...
		} else {
			parser.showHelp();
		}

		Shape3D[] shapes;

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

		// Sorting
		SortingUtility.Sort(parser.getSortType(), shapes, comparator);

		// Get end time
		long endTime = System.nanoTime();
		// Calculate and output the time required
		long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds

		System.out.println("Sorting took: " + duration + " milliseconds.");

	}
}

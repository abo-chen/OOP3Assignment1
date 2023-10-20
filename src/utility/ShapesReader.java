package utility;

import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;

import shape.Shape3D;

/**
 * A utility class to read shape data from large files.
 * <p>
 * The class uses {@link RandomAccessFile} to read shape data from large files.
 * Each file contains information about various shapes, including their type and
 * dimensions.
 * </p>
 */
public class ShapesReader {

	/**
	 * Reads shapes data from the specified file.
	 *
	 * @param filePath the path to the file containing shape data.
	 * @return an array of {@link Shape3D} objects representing the shapes read from
	 *         the file.
	 * @throws Exception if an error occurs during file reading or shape
	 *                   instantiation.
	 */
	public static Shape3D[] readShapesFromLargeFile(String filePath) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(filePath, "r")) {
			// Read the first number, the shape number
			String firstField = readField(raf);
			int numOfShapes = Integer.parseInt(firstField);

			Shape3D[] shapes = new Shape3D[numOfShapes];
			System.out.print("loading " + numOfShapes + " Datas ... ");
			int shapeIndex = 0;

			while (shapeIndex < numOfShapes) {
				// if(shapeIndex == (numOfShapes-3))
				// System.out.println("almost ..");
				String shapeType = readField(raf);
				double val1 = Double.parseDouble(readField(raf));
				double val2 = Double.parseDouble(readField(raf));

				// Use reflection to create an instance of the shape based on its type
				Shape3D shape = createShapeInstance(shapeType, val1, val2);

				if (shape != null) {
					shapes[shapeIndex++] = shape;
				}
			}

			return shapes;
		}
	}

	/**
	 * Creates an instance of a {@link Shape3D} subtype based on the provided shape
	 * type and parameters.
	 * 
	 * <p>
	 * This method uses reflection to dynamically create an object of the desired
	 * shape type found within the "shape" package. It assumes that each shape class
	 * in this package has a constructor that accepts two double parameters. If the
	 * shape type does not exist or any error occurs during instantiation, this
	 * method will return {@code null} and print an error message to the console.
	 * </p>
	 * 
	 * @param shapeType The name of the desired shape type, e.g., "Cylinder",
	 *                  "Cone", etc.
	 * @param val1      The first parameter for the shape's constructor. Its meaning
	 *                  depends on the specific shape type, but it's typically
	 *                  related to some dimension like radius or base length.
	 * @param val2      The second parameter for the shape's constructor. Its
	 *                  meaning is also shape-specific, often representing another
	 *                  dimension like height.
	 * @return A new instance of the specified {@link Shape3D} subtype, or
	 *         {@code null} if instantiation fails for any reason.
	 */
	private static Shape3D createShapeInstance(String shapeType, double val1, double val2) {
		try {
			String packageName = "shape."; // Assuming all shape classes are in the "shape" package
			Class<?> clazz = Class.forName(packageName + shapeType);

			Constructor<?> constructor = clazz.getConstructor(double.class, double.class);
			return (Shape3D) constructor.newInstance(val1, val2);
		} catch (Exception e) {
			System.out.println("Failed to create an instance of " + shapeType + ": " + e.getMessage());
			return null;
		}
	}

	/**
	 * Reads a field from the given {@link RandomAccessFile}. A field can be a shape
	 * name or a number.
	 *
	 * @param raf the {@link RandomAccessFile} from which the field is to be read.
	 * @return a {@link String} representing the field read from the file.
	 * @throws Exception if an error occurs during reading.
	 */
	private static String readField(RandomAccessFile raf) throws Exception {
		StringBuilder field = new StringBuilder();
		char ch;
		int data; // Use an int variable to store the read character
		while ((data = raf.read()) != -1) {
			ch = (char) data;
			if (ch == ' ') {
				break;
			}
			field.append(ch);
		}
		return field.toString();
	}

}

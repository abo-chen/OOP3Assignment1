package utility;
import java.io.RandomAccessFile;
import shape.Cone;
import shape.Cylinder;
import shape.OctagonalPrism;
import shape.PentagonalPrism;
import shape.Pyramid;
import shape.Shape3D;
import shape.SquarePrism;
import shape.TriangularPrism;

/**
 * A utility class to read shape data from large files.
 * <p>
 * The class uses {@link RandomAccessFile} to read shape data from large files.
 * Each file contains information about various shapes, including their type and dimensions.
 * </p>
 */
public class ShapesReader {
	
	/**
     * Reads shapes data from the specified file.
     *
     * @param filePath the path to the file containing shape data.
     * @return an array of {@link Shape3D} objects representing the shapes read from the file.
     * @throws Exception if an error occurs during file reading or shape instantiation.
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

				switch (shapeType) {
				case "Cylinder":
					shapes[shapeIndex++] = new Cylinder(val1, val2);
					break;
				case "Cone":
					shapes[shapeIndex++] = new Cone(val1, val2);
					break;
				case "Pyramid":
					shapes[shapeIndex++] = new Pyramid(val1, val2);
					break;
				case "SquarePrism":
					shapes[shapeIndex++] = new SquarePrism(val1, val2);
					break;
				case "TriangularPrism":
					shapes[shapeIndex++] = new TriangularPrism(val1, val2);
					break;
				case "PentagonalPrism":
					shapes[shapeIndex++] = new PentagonalPrism(val1, val2);
					break;
				case "OctagonalPrism":
					shapes[shapeIndex++] = new OctagonalPrism(val1, val2);
					break;
				}
			}

			return shapes;
		}
	}

    /**
     * Reads a field from the given {@link RandomAccessFile}. A field can be a shape name or a number.
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

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

public class ShapesReader {

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

	// 从RandomAccessFile读取一个字段（形状名称或数字）
	private static String readField(RandomAccessFile raf) throws Exception {
		StringBuilder field = new StringBuilder();
		char ch;
		int data; // 使用一个int变量来存储读取到的字符
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

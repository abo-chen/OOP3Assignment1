package shape;

/**
 * Represents an octagonal prism shape. The octagonal prism is defined by its side length and height.
 * Provides methods for retrieving properties of the prism such as height, base area, and volume.
 */
public class OctagonalPrism extends Shape3D {
	
	/** The side length of the base octagon. */
	private double sideLength;
	
	/** The height of the octagonal prism. */
	private double height;

	/**
	 * Constructs a new octagonal prism with the specified side length and height.
	 *
	 * @param sideLength the side length of the base octagon.
	 * @param height the height of the octagonal prism.
	 */
	public OctagonalPrism(double sideLength, double height) {
		this.sideLength = sideLength;
		this.height = height;
	}

	/**
	 * Retrieves the height of the octagonal prism.
	 *
	 * @return the height of the octagonal prism.
	 */
	@Override
	public double getHeight() {
		return height;
	}

	/**
	 * Calculates and returns the base area of the octagonal prism.
	 *
	 * @return the base area of the octagonal prism.
	 */
	@Override
	public double getBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * sideLength * sideLength;
	}

	/**
	 * Calculates and returns the volume of the octagonal prism.
	 *
	 * @return the volume of the octagonal prism.
	 */
	@Override
	public double getVolume() {
		return getBaseArea() * height;
	}
}

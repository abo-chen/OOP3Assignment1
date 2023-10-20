package shape;

/**
 * Represents a square prism shape. The square prism is defined by its side length and height.
 * Provides methods for retrieving properties of the square prism such as height, base area, and volume.
 */
public class SquarePrism extends Shape3D {
	
	/** The side length of the square base of the prism. */
	private double sideLength;
	
	/** The height of the prism. */
	private double height;

	/**
	 * Constructs a new square prism with the specified side length and height.
	 *
	 * @param sideLength the side length of the square base.
	 * @param height the height of the prism.
	 */
	public SquarePrism(double sideLength, double height) {
		this.sideLength = sideLength;
		this.height = height;
	}

	/**
	 * Retrieves the height of the prism.
	 *
	 * @return the height of the prism.
	 */
	@Override
	public double getHeight() {
		return height;
	}

	/**
	 * Calculates and returns the base area of the prism.
	 *
	 * @return the base area of the prism.
	 */
	@Override
	public double getBaseArea() {
		return sideLength * sideLength;
	}

	/**
	 * Calculates and returns the volume of the prism.
	 *
	 * @return the volume of the prism.
	 */
	@Override
	public double getVolume() {
		return getBaseArea() * height;
	}
}

package shape;

/**
 * Represents a pentagonal prism shape. The pentagonal prism is defined by its side length and height.
 * Provides methods for retrieving properties of the prism such as height, base area, and volume.
 */
public class PentagonalPrism extends Shape3D {
	
	/** The side length of the base pentagon. */
	private double sideLength;
	
	/** The height of the pentagonal prism. */
	private double height;

	
	/**
	 * Constructs a new pentagonal prism with the specified side length and height.
	 *
	 * @param sideLength the side length of the base pentagon.
	 * @param height the height of the pentagonal prism.
	 */
	public PentagonalPrism(double sideLength, double height) {
		this.sideLength = sideLength;
		this.height = height;
	}

	/**
	 * Retrieves the height of the pentagonal prism.
	 *
	 * @return the height of the pentagonal prism.
	 */
	@Override
	public double getHeight() {
		return height;
	}

	/**
	 * Calculates and returns the base area of the pentagonal prism.
	 *
	 * @return the base area of the pentagonal prism.
	 */
	@Override
	public double getBaseArea() {
		return (5.0 / 4) * (Math.tan(Math.PI / 5)) * sideLength * sideLength;
	}

	/**
	 * Calculates and returns the volume of the pentagonal prism.
	 *
	 * @return the volume of the pentagonal prism.
	 */
	@Override
	public double getVolume() {
		return getBaseArea() * height;
	}
}

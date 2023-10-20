package shape;

/**
 * Represents a triangular prism with an equilateral triangle as its base.
 * The triangular prism is defined by its base side length and height.
 * Provides methods for retrieving properties of the triangular prism such as height, base area, and volume.
 */
public class TriangularPrism extends Shape3D {
	
	/** The side length of the equilateral triangle base of the prism. */
	private double baseLength; // Equilateral triangle side length
	
	/** The height of the prism. */
	private double height;

	/**
	 * Constructs a new triangular prism with the specified base side length and height.
	 *
	 * @param baseLength the side length of the equilateral triangle base.
	 * @param height the height of the prism.
	 */
	public TriangularPrism(double baseLength, double height) {
		this.baseLength = baseLength;
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
	 * Calculates and returns the base area of the prism using the formula for the area of an equilateral triangle.
	 *
	 * @return the base area of the prism.
	 */
	@Override
	public double getBaseArea() {
		return (Math.sqrt(3) / 4) * baseLength * baseLength;
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

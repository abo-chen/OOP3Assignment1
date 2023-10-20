package shape;

/**
 * Represents a pyramid shape with a square base. The pyramid is defined by its base length and height.
 * Provides methods for retrieving properties of the pyramid such as height, base area, and volume.
 */
public class Pyramid extends Shape3D {
	
	/** The side length of the square base of the pyramid. */
	private double baseLength; // Assuming a square base
	
	/** The height of the pyramid. */
	private double height;

	/**
	 * Constructs a new pyramid with the specified base length and height.
	 *
	 * @param baseLength the side length of the square base.
	 * @param height the height of the pyramid.
	 */
	public Pyramid(double baseLength, double height) {
		this.baseLength = baseLength;
		this.height = height;
	}

	/**
	 * Retrieves the height of the pyramid.
	 *
	 * @return the height of the pyramid.
	 */
	@Override
	public double getHeight() {
		return height;
	}

	/**
	 * Calculates and returns the base area of the pyramid.
	 *
	 * @return the base area of the pyramid.
	 */
	@Override
	public double getBaseArea() {
		return baseLength * baseLength;
	}

	/**
	 * Calculates and returns the volume of the pyramid.
	 *
	 * @return the volume of the pyramid.
	 */
	@Override
	public double getVolume() {
		return (1.0 / 3) * getBaseArea() * height;
	}
}

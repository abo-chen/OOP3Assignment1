package shape;

/**
 * Represents a cone shape. The cone is defined by its radius and height.
 * Provides methods for retrieving properties of the cone such as height, base area, and volume.
 */
public class Cone extends Shape3D {
	
	/** The radius of the cone. */
	private double radius;
	
	/** The height of the cone. */
	private double height;

	/**
	 * Constructs a new cone with the specified radius and height.
	 *
	 * @param radius the radius of the cone.
	 * @param height the height of the cone.
	 */
	public Cone(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}

	/**
	 * Retrieves the height of the cone.
	 *
	 * @return the height of the cone.
	 */
	@Override
	public double getHeight() {
		return height;
	}

	/**
	 * Calculates and returns the base area of the cone.
	 *
	 * @return the base area of the cone.
	 */
	@Override
	public double getBaseArea() {
		return Math.PI * radius * radius;
	}

	/**
	 * Calculates and returns the volume of the cone.
	 *
	 * @return the volume of the cone.
	 */
	@Override
	public double getVolume() {
		return (1.0 / 3) * getBaseArea() * height;
	}
}

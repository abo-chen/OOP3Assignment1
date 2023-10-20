package shape;

/**
 * Represents a cylinder shape. The cylinder is defined by its height and radius.
 * Provides methods for retrieving properties of the cylinder such as height, base area, and volume.
 */
public class Cylinder extends Shape3D {
	
	/** The height of the cylinder. */
	private double height;
	
	/** The height of the cylinder. */
	private double radius;

	/**
	 * Constructs a new cylinder with the specified height and radius.
	 *
	 * @param height the height of the cylinder.
	 * @param radius the radius of the cylinder.
	 */
	public Cylinder(double height, double radius) {
		this.height = height;
		this.radius = radius;
	}

	/**
	 * Retrieves the height of the cylinder.
	 *
	 * @return the height of the cylinder.
	 */
	@Override
	public double getHeight() {
		return height;
	}

	/**
	 * Calculates and returns the base area of the cylinder.
	 *
	 * @return the base area of the cylinder.
	 */
	@Override
	public double getBaseArea() {
		return Math.PI * radius * radius;
	}

	/**
	 * Calculates and returns the volume of the cylinder.
	 *
	 * @return the volume of the cylinder.
	 */
	@Override
	public double getVolume() {
		return getBaseArea() * height;
	}
}

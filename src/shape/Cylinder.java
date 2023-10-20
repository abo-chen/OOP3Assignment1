package shape;
public class Cylinder extends Shape3D {
	private double height;
	private double radius;

	public Cylinder(double height, double radius) {
		this.height = height;
		this.radius = radius;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public double getBaseArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double getVolume() {
		return getBaseArea() * height;
	}
}

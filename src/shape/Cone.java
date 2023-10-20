package shape;
public class Cone extends Shape3D {
	private double radius;
	private double height;

	public Cone(double radius, double height) {
		this.radius = radius;
		this.height = height;
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
		return (1.0 / 3) * getBaseArea() * height;
	}
}

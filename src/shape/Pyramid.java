package shape;
public class Pyramid extends Shape3D {
	private double baseLength; // Assuming a square base
	private double height;

	public Pyramid(double baseLength, double height) {
		this.baseLength = baseLength;
		this.height = height;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public double getBaseArea() {
		return baseLength * baseLength;
	}

	@Override
	public double getVolume() {
		return (1.0 / 3) * getBaseArea() * height;
	}
}

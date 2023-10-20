package shape;
public class TriangularPrism extends Shape3D {
	private double baseLength; // Equilateral triangle side length
	private double height;

	public TriangularPrism(double baseLength, double height) {
		this.baseLength = baseLength;
		this.height = height;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public double getBaseArea() {
		return (Math.sqrt(3) / 4) * baseLength * baseLength;
	}

	@Override
	public double getVolume() {
		return getBaseArea() * height;
	}
}

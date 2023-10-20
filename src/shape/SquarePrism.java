package shape;
public class SquarePrism extends Shape3D {
	private double sideLength;
	private double height;

	public SquarePrism(double sideLength, double height) {
		this.sideLength = sideLength;
		this.height = height;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public double getBaseArea() {
		return sideLength * sideLength;
	}

	@Override
	public double getVolume() {
		return getBaseArea() * height;
	}
}

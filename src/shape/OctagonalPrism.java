package shape;
public class OctagonalPrism extends Shape3D {
	private double sideLength;
	private double height;

	public OctagonalPrism(double sideLength, double height) {
		this.sideLength = sideLength;
		this.height = height;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public double getBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * sideLength * sideLength;
	}

	@Override
	public double getVolume() {
		return getBaseArea() * height;
	}
}

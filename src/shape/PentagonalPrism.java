package shape;
public class PentagonalPrism extends Shape3D {
	private double sideLength;
	private double height;

	public PentagonalPrism(double sideLength, double height) {
		this.sideLength = sideLength;
		this.height = height;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public double getBaseArea() {
		return (5.0 / 4) * (Math.tan(Math.PI / 5)) * sideLength * sideLength;
	}

	@Override
	public double getVolume() {
		return getBaseArea() * height;
	}
}

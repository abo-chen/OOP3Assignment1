package shape;
import java.util.Comparator;

public abstract class Shape3D implements Comparable<Shape3D> {
	public enum CompareType {
		H, // HEIGHT
		V, // VOLUME
		A; // BASE_AREA

		public static CompareType fromString(String s) {
			switch (s.toLowerCase()) {
			case "h":
				return H;
			case "v":
				return V;
			case "a":
				return A;
			default:
				throw new IllegalArgumentException("Invalid compare type: " + s); // Invalid argument
			}
		}

		public static Comparator<Shape3D> getComparator(Shape3D.CompareType compareType) {
			switch (compareType) {
			case H:
				return Comparator.comparingDouble(Shape3D::getHeight);
			case V:
				return Comparator.comparingDouble(Shape3D::getVolume);
			case A:
				return Comparator.comparingDouble(Shape3D::getBaseArea);
			default:
				throw new IllegalArgumentException("Invalid CompareType");
			}
		}
	}

	public abstract double getHeight();

	public abstract double getBaseArea();

	public abstract double getVolume();

	@Override
	public int compareTo(Shape3D other) {
		return Double.compare(this.getHeight(), other.getHeight());
	}

}
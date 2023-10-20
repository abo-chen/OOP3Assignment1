package shape;
import java.util.Comparator;

/**
 * Represents a 3D shape. Provides abstract methods for retrieving properties
 * of the shape such as height, base area, and volume. Also defines the ability
 * to compare shapes based on certain criteria.
 */
public abstract class Shape3D implements Comparable<Shape3D> {
	
	/**
     * Enum representing the types of criteria by which shapes can be compared.
     */
	public enum CompareType {
		H, // HEIGHT
		V, // VOLUME
		A; // BASE_AREA

        /**
         * Converts a string representation to its respective {@code CompareType}.
         *
         * @param s the string representation.
         * @return the corresponding {@code CompareType}.
         * @throws IllegalArgumentException if the string does not match any {@code CompareType}.
         */
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

        /**
         * Provides a comparator for {@code Shape3D} based on the given {@code compareType}.
         *
         * @param compareType the type of comparison criteria.
         * @return a comparator for {@code Shape3D}.
         * @throws IllegalArgumentException if the provided {@code compareType} is invalid.
         */
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

    /**
     * Retrieves the height of the shape.
     *
     * @return the height of the shape.
     */
	public abstract double getHeight();

    /**
     * Retrieves the base area of the shape.
     *
     * @return the base area of the shape.
     */
	public abstract double getBaseArea();

    /**
     * Retrieves the volume of the shape.
     *
     * @return the volume of the shape.
     */
	public abstract double getVolume();

    /**
     * Compares this shape to another based on their heights.
     *
     * @param other the other shape to compare to.
     * @return a negative integer, zero, or a positive integer if this shape's height
     *         is less than, equal to, or greater than the specified shape's height respectively.
     */
	@Override
	public int compareTo(Shape3D other) {
		return Double.compare(this.getHeight(), other.getHeight());
	}

}
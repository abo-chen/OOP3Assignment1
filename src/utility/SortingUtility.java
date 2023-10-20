package utility;

import java.util.Comparator;
import shape.Shape3D;

/**
 * A utility class that provides multiple sorting algorithms to sort arrays of
 * {@link Shape3D}. The sorting is based on custom comparison logic provided via
 * {@link Comparator<Shape3D>}.
 */
public class SortingUtility {

	/**
	 * Sorts the given array of shapes using heap sort algorithm.
	 *
	 * @param shapes     the array of shapes to be sorted.
	 * @param comparator the comparator to determine the order of the shapes.
	 */
	public static void heapSort(Shape3D[] shapes, Comparator<Shape3D> comparator) {
		int n = shapes.length;

		// Build a heap
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(shapes, n, i, comparator);

		// Extract elements from the heap one by one
		for (int i = n - 1; i >= 0; i--) {
			Shape3D temp = shapes[0];
			shapes[0] = shapes[i];
			shapes[i] = temp;

			// Call heapify on the reduced heap
			heapify(shapes, i, 0, comparator);
		}
	}

	private static void heapify(Shape3D[] shapes, int n, int i, Comparator<Shape3D> comparator) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && comparator.compare(shapes[left], shapes[largest]) > 0)
			largest = left;

		if (right < n && comparator.compare(shapes[right], shapes[largest]) > 0)
			largest = right;

		if (largest != i) {
			Shape3D swap = shapes[i];
			shapes[i] = shapes[largest];
			shapes[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(shapes, n, largest, comparator);
		}
	}

	/**
	 * Sorts the given array of shapes using bubble sort algorithm.
	 *
	 * @param shapes     the array of shapes to be sorted.
	 * @param comparator the comparator to determine the order of the shapes.
	 */
	public static void bubbleSort(Shape3D[] shapes, Comparator<Shape3D> comparator) {
		int n = shapes.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (comparator.compare(shapes[j], shapes[j + 1]) > 0) {
					Shape3D temp = shapes[j];
					shapes[j] = shapes[j + 1];
					shapes[j + 1] = temp;
				}
	}

	/**
	 * Sorts the given array of shapes using insertion sort algorithm.
	 *
	 * @param shapes     the array of shapes to be sorted.
	 * @param comparator the comparator to determine the order of the shapes.
	 */
	public static void insertionSort(Shape3D[] shapes, Comparator<Shape3D> comparator) {
		int n = shapes.length;
		for (int i = 1; i < n; i++) {
			Shape3D key = shapes[i];
			int j = i - 1;

			while (j >= 0 && comparator.compare(shapes[j], key) > 0) {
				shapes[j + 1] = shapes[j];
				j = j - 1;
			}
			shapes[j + 1] = key;
		}
	}

	/**
	 * Sorts the given array of shapes using selection sort algorithm.
	 *
	 * @param shapes     the array of shapes to be sorted.
	 * @param comparator the comparator to determine the order of the shapes.
	 */
	public static void selectionSort(Shape3D[] shapes, Comparator<Shape3D> comparator) {
		int n = shapes.length;
		for (int i = 0; i < n - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < n; j++)
				if (comparator.compare(shapes[j], shapes[minIdx]) < 0)
					minIdx = j;

			Shape3D temp = shapes[minIdx];
			shapes[minIdx] = shapes[i];
			shapes[i] = temp;
		}
	}

	/**
	 * Sorts the given array of shapes using merge sort algorithm.
	 *
	 * @param shapes     the array of shapes to be sorted.
	 * @param comparator the comparator to determine the order of the shapes.
	 */
	public static void mergeSort(Shape3D[] shapes, Comparator<Shape3D> comparator) {
		mergeSortHelper(shapes, 0, shapes.length - 1, comparator);
	}

	private static void mergeSortHelper(Shape3D[] shapes, int l, int r, Comparator<Shape3D> comparator) {
		if (l < r) {
			int m = l + (r - l) / 2;
			mergeSortHelper(shapes, l, m, comparator);
			mergeSortHelper(shapes, m + 1, r, comparator);
			merge(shapes, l, m, r, comparator);
		}
	}

	private static void merge(Shape3D[] shapes, int l, int m, int r, Comparator<Shape3D> comparator) {
		int n1 = m - l + 1;
		int n2 = r - m;

		Shape3D[] L = new Shape3D[n1];
		Shape3D[] R = new Shape3D[n2];

		System.arraycopy(shapes, l, L, 0, n1);
		System.arraycopy(shapes, m + 1, R, 0, n2);

		int i = 0, j = 0, k = l;

		while (i < n1 && j < n2) {
			if (comparator.compare(L[i], R[j]) <= 0) {
				shapes[k++] = L[i++];
			} else {
				shapes[k++] = R[j++];
			}
		}

		while (i < n1) {
			shapes[k++] = L[i++];
		}

		while (j < n2) {
			shapes[k++] = R[j++];
		}
	}

	/**
	 * Sorts the given array of shapes using quick sort algorithm.
	 *
	 * @param shapes     the array of shapes to be sorted.
	 * @param comparator the comparator to determine the order of the shapes.
	 */
	public static void quickSort(Shape3D[] shapes, Comparator<Shape3D> comparator) {
		quickSortHelper(shapes, 0, shapes.length - 1, comparator);
	}

	private static void quickSortHelper(Shape3D[] shapes, int low, int high, Comparator<Shape3D> comparator) {
		if (low < high) {
			int pivotIdx = partition(shapes, low, high, comparator);
			quickSortHelper(shapes, low, pivotIdx - 1, comparator);
			quickSortHelper(shapes, pivotIdx + 1, high, comparator);
		}
	}

	private static int partition(Shape3D[] shapes, int low, int high, Comparator<Shape3D> comparator) {
		Shape3D pivot = shapes[high];
		int i = (low - 1);

		for (int j = low; j < high; j++) {
			if (comparator.compare(shapes[j], pivot) <= 0) {
				i++;
				Shape3D temp = shapes[i];
				shapes[i] = shapes[j];
				shapes[j] = temp;
			}
		}

		Shape3D temp = shapes[i + 1];
		shapes[i + 1] = shapes[high];
		shapes[high] = temp;

		return i + 1;
	}

	/**
	 * Sorts the given array of shapes based on the specified sorting type.
	 *
	 * @param sortType   the type of sorting algorithm to use.
	 * @param shapes     the array of shapes to be sorted.
	 * @param comparator the comparator to determine the order of the shapes.
	 */
	public static void Sort(String sortType, Shape3D[] shapes, Comparator<Shape3D> comparator) {

		switch (sortType.toLowerCase()) {
		case "b":
			bubbleSort(shapes, comparator);
			break;
		case "i":
			insertionSort(shapes, comparator);
			break;
		case "s":
			selectionSort(shapes, comparator);
			break;
		case "m":
			mergeSort(shapes, comparator);
			break;
		case "q":
			quickSort(shapes, comparator);
			break;
		case "z":
			heapSort(shapes, comparator);
			break;
		default:
			System.out.println("Invalid sorting algorithm: " + sortType);
		}
	}
}

# Team 4 : Assignment 1

Hello! We are Team 4.

Following the given instructions, we have developed this project, which is currently running smoothly.

## Custom Sorting: Heap Sort

Heap sort is a comparison-based sorting technique based on a binary heap data structure. It divides its input into a sorted and an unsorted region, and it iteratively shrinks the unsorted region by extracting the largest element and moving that to the sorted region. The key improvement is the use of a heap data structure rather than a linear-time search to find the maximum.

### Steps:

1. Build a max heap (or min heap, if you're sorting in ascending order) from the input data.
2. The largest item is stored at the root of the heap. Replace it with the last item of the heap, followed by reducing the size of the heap by one. Finally, heapify the root of the tree.
3. Repeat step 2 while the size of the heap is not one.

### Description:

Heap sort is not a stable sort, meaning the relative order of equal sort items is not preserved. However, it boasts a consistent O(n log n) time complexity, even in its worst-case scenario. This can make it faster than algorithms like QuickSort in certain situations where QuickSort degrades to O(n^2).

## Testing

We use a 'test.bat' batch file to test `sort.jar`, and then record the output to `out.txt`.

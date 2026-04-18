package sorting;

//import java.util.Random;

public class Sorting {

	public static void main(String[] args) {

		// define an array with the size
		int size = 50000;
		int a[] = new int[size];

		for (int i = 0; i < a.length; i++) {

			a[i] =  i;
		}

		// to generate a random values
//		Random rand = new Random();
//		for (int i = 0; i < size; i++) {
//			a[i] = rand.nextInt(100); }

		// calling selectionSort
		long start = System.nanoTime();
		Sorting.selectionSort(a, size);
		long end = System.nanoTime();
		long result = end - start;
		System.out.println(result / 1000000 + "mS");

		long s = System.nanoTime();
		Sorting.mergeSort(a);
		long e = System.nanoTime();
		long r = e - s;
		System.out.println(r / 1000000 + "mS");

	}

	// implementation of the selection sort algorithm
	// this operation for sorting array that is need to sort
	// it works by compare each item in the all other items and swapping, the array
	// must be sorted in increasing order
	// this operation take n^2 unit of time --> quadratic time, O(n^2)
	public static void selectionSort(int a[], int size) {

		// to calculate a execution/run time in nano
		// to store the starting time
//		long start = System.nanoTime();

		// the outer loop should select item by item so, it can be compared with the
		// other items in the inner loop
		for (int i = 0; i < size - 1; i++) {

			// iMin variable it should store the index of the item that will be compared
			// with
			int iMin = i;

			// the inner loop that will be compared the item in the iMin index with the
			// other items
			for (int j = i + 1; j < size; j++) {

				// comparison, to determine the minimum value
				if (a[j] <= a[iMin]) {

					// if a[j] less than a[iMin], let the value of iMin = j (the index of the
					// minimum value)
					iMin = j;
				}

				// swapping
				int temp = a[i];
				a[i] = a[iMin];
				a[iMin] = temp;

			}

		}

		// print, just to test
//		for (int p = 0; p < size; p++) {
//			System.out.print(a[p]);
//
//			if (p < size - 1)
//				System.out.print(", ");
//		}
//		System.out.println();
//
//		// to store the ending time in nano
//		long end = System.nanoTime();
//
//		// the result of time, execution/run time in nano
//		long result = end - start;
//
//		// print the result, execution/run time in mS
//		System.out.println(result / 1000000 + "mS");

	}

	public static void merge(int left[], int right[], int a[]) {

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < left.length && j < right.length) {

			if (left[i] < right[j]) {
				a[k] = left[i];
				i++;
			} else {
				a[k] = right[j];
				j++;
			}
			k++;

		}

		while (i < left.length) {
			a[k] = left[i];
			i++;
			k++;
		}

		while (j < right.length) {
			a[k] = right[j];
			j++;
			k++;
		}

	}

	public static void mergeSort(int a[]) {

//		long start = System.nanoTime();

		if (a.length == 1)
			return;

		int mid = a.length / 2;
		int left[] = new int[mid];
		int right[] = new int[a.length - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = a[i];
		}
		for (int j = mid; j < a.length; j++) {
			right[j - mid] = a[j];
		}
		mergeSort(left);
		mergeSort(right);
		merge(left, right, a);

//		long end = System.nanoTime();
//		
//		long result = end - start;
//		
//		System.out.println(result / 1000000 + "ms");

	}

	public static void print(int a[]) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}

import java.util.Scanner;

public class quickSort {
	public int[] A;
	public int n;

	public void sort (int[] values) {
		this.A = values;
		n = values.length;
		quicksort (0, n - 1);
	}

	public void quicksort (int low, int high){
		int i = low+1, j = high;
		int pivot = 0;
		try{
			pivot = A[low];
		}
		catch (Exception e){
			System.out.println(low);
		}
		while (i <= j) {
			while (A[i] < pivot && i <= j){
				i++;
			}
			while (A[j] > pivot){
				j--;
			}
				// exchange if needed
				// As we are done we can increase i and j
			if (i < j) {
				exchange (i, j);
				i++;
				j--;
			}
		}
		exchange (low, j);
		// Recursion
		if (low < j - 1)
			quicksort (low, j - 1);
		if (j+1 < high)
			quicksort (j+1, high);
	}

	public void exchange (int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void main(String[] args){
		A = {3,4,5,1,2};
		System.out.println(A[0]);
		quickSort q1 = new quickSort();
		q1.quicksort(0, 4);
		for(int element : A){
			System.out.print(element);
		}
	}
}

import java.util.Scanner;

class Sort{
	public static int[] a;
	public static int[] temp;
	public static int n;
	
	public static void sort(int []a, int n){
		this.a = a;
		this.temp = new int[n];
		mergesort(0, n - 1);
	}

	public static void mergesort(int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergesort(low, middle);
			mergesort(middle + 1, high);
			// Combine both the sorted subarrays
			merge(low, middle, high);
		}
	} 

	public static void merge(int low, int middle, int high) {
		// Copy contents of A into aux array
		for (int i = low; i <= high; i++) {
			temp[i] = a[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
		while (i <= middle && j <= high) {
			if (temp[i] <= temp[j]) {
				a[k] = temp[i];
				i++;
			} else {
				a[k] = temp[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			a[k] = temp[i];
			k++;
			i++;
		}
		while (j <= high) {
			a[k] = temp[j];
			k++;
			j++;
		}
	}
}

class mergeSort{
	public static Sort s = new Sort();

	public static void main(String[] args){
		int [] a = {1,7,8,2,6};
		s.sort(a, 5);
		for(int i=0; i<5; i++){
			System.out.println(a[i]);
		}
	}
}

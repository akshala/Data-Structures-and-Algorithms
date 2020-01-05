import java.util.Scanner;

public class mergeSort{
	public int[] a; 
	public int[] temp;
	public int n;

	public void sort(int[] a, int n){
		this.a = a;
		this.temp = new int[n];
		mergesort(a, n-1);
	}

	public void mergesort(int low, int high){
		if(low<high){
			int middle = (low+high) / 2;
			mergesort(low, middle);
			mergesort(middle+1, high);
			merge(low, middle, high);
		}
	}
	public void merge(int low, int middle, int high){
		for(int i=low; i<=high; i++){
			temp[i] = a[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
		while(i<= middle and j<=high){
			if(temp[i] < temp[j]){
				a[k] = temp[i];
				i++;
			}
			else{
				a[k] = temp[j];
				j++;
			}
			k++;
		}
		while(i<=middle){
			a[k] = a[i];
			i++;
			k++;
		}
		while(j<=high){
			a[k] = a[j];
			j++;
			k++;
		}
	}
}
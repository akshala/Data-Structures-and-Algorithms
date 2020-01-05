import java.util.Scanner;

class binaryHeap{
	public static int size = 0;
	public static int[] heap = new int[10000];

	// public binaryHeap(int capacity){
	// 	heap = new int[capacity + 1];
	// }

	public boolean isEmpty(){
		if(size <= 0){
			return true;
		}
		return false;
	}

	public int parent(int i){
		//index of parent of i
		return heap[(i-1)/2];
	}

	public int leftChild(int i){
		return heap[2*i + 1];
	}

	public int rightChild(int i){
		return heap[2*i + 2];
	}

	public void swap(){

	}

	// public int kChild(int k, int i){
	// 	return 2*i + k;
	// }

	public int findMin(){
		return heap[0];
	}

	// public void insertBasic(int x){
	// 	int i = size;
	// 	int parent = (i-1)/2;
	// 	heap[size] = x;
	// 	size = size + 1;
	// 	while(i>0 && heap[i] < heap[parent]){
	// 		int temp = heap[i];
	// 		heap[i] = heap[parent];
	// 		heap[parent] = temp;
	// 		i = parent;
	// 	}
	// 	size++;
	// }

	public void heapify(int i){
		int n = size - 1;
		int left = 2*i + 1;
		int right = 2*i + 2;
		boolean flag = true;
		while(i<=(n-1)/2 && flag == true){
			int min = i;
			if(heap[i] > heap[left]){
				min = left;
			}
			if((right) <=n && heap[min] > heap[right]){
				min = right;
			}
			if(min != i){
				int temp = heap[i];
				heap[i] = heap[min];
				heap[min] = temp;
			}
			else{
				flag = false;
			}
		}
	}


	public void extractMin(){
		heap[0] = heap[size-1];
		size--;
		if(size > 0){
			heapDown(0);
		}
	}

	public void heapDown(int i){
		int left = 2*i + 1;
		int right = 2*i + 2;
		int min;
		if(right >= size){
			if(left >= size){
				return;
			}
			min = left;
		}
		else if(heap[right] > heap[left]){
			min = left;
		}
		else{
			min = right;
		}
		if(heap[i] > heap[min]){
			int temp = heap[i];
			heap[i] = heap[min];
			heap[min] = temp;
			heapDown(min);
		}
	}

	public void heapUp(int i){
		int parent = (i-1)/2;
		if(i != 0){
			if(heap[parent] > heap[i]){
				int temp = heap[parent];
				heap[parent] = heap[i];
				heap[i] = temp;
				heapUp(parent);
			}
		}
	}

	public void heapify(){
		for(int i=0; i<size; i++){
			heapUp(i);
		}
	}

	public void insert(int x){
		size++;
		heap[size-1] = x;
		heapUp(size-1);
	}

	public void print(){
		for(int i=0; i<size; i++){
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}

	public void decreaseKey(int p, int delta){
		heap[p] = heap[p] - delta;
		heapUp(p);
	}

	public int[] merge(int merged, int[] h1, int[] h2){
		int n1 = h1.length;
		int n2 = h2.length;
		for(int i=0; i<n1; i++){
			merged[i] = h1[i];
		}
		for(int i=0; i<n2; i++){
			merged[n1 + i] = h2[i];
		}
		heapDown(0);
		return merged;
	}
}

public class heap{
	public static binaryHeap h = new binaryHeap();

	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		h.print();
		h.insert(5);
		h.print();
		h.insert(2);
		h.print();
		h.insert(3);
		h.print();
		h.extractMin();
		h.print();
	}
}
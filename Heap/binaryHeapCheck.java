import java.util.Scanner;

class binaryHeapCheck { 
  
    static boolean isHeap(int arr[], int i, int n) { 

        if (n<2*i + 2) { 
            return true; 
        } 
   
        if (arr[i] >= arr[2 * i + 1] && arr[i] >= arr[2 * i + 1] && isHeap(arr, 2 * i + 1, n) && isHeap(arr, 2 * i + 2, n)) { 
            return true; 
        }   
        return false; 
    } 
  
    public static void main(String[] args) { 
        int arr[] = {90, 15, 10, 7, 12, 2, 7, 3}; 
        int n = arr.length-1; 
        if (isHeap(arr, 0, n)) { 
            System.out.println("Yes"); 
        } else { 
            System.out.println("No"); 
        } 
    } 
} 
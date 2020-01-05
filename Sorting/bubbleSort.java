import java.util.Scanner;

public class bubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
	    System.out.print("Enter number of terms: ");
	    int number = scanner.nextInt();
	    int [] a = new int[number];
	    System.out.print("Enter the terms: ");
	    for(int k = 0; k < number; k++) {	
		    a[k] = scanner.nextInt();
		    System.out.println(a[k]);
	    }
	    scanner.close();
	    System.out.println(a);
	    for(int i = 0; i < number - 1; i++) {
	    	for(int j = i + 1; j < number; j++) {
	    		if(a[j] < a[i]) {
	    			int temp = a[j];
	    			a[j] = a[i];
	    			a[i] = temp;
	    		}
	    	}
	    }
	    System.out.println("Increasing order is: ");
	    System.out.println(a);
	}
}
import java.util.Scanner;

public class graph{
	public boolean G(int[] degree){
		int flag = 0;
		degree = sort(degree);
		for(int i = 0; i < degree.length; i++){
			if(degree[i] < 0){
				return false;
			}
			else if(degree[i] != 0){
				flag = 1;
			}
		}
		if(flag == 0){
			return true;
		}
		int max = degree[0];
		degree[0] = 0;
		for(int i = 1; i <= max; i++){
			degree[i] -= 1;
		}
		return G(degree);
	}

	public static int[] sort(int[] a){
		for(int i = 0; i < a.length - 1; i++){
			for(int j = i; j < a.length; j++){
				if(a[i] < a[j]){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}

	public static void main(String[] args){
		int[] a = {3,3,2,2};
		graph myGraph = new graph();
		boolean ans = myGraph.G(a);
		if(ans){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
	}
}
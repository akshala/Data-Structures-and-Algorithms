import java.util.Scanner;

class graph2{
	public int[][] adj;
	public int vertices;

	public graph(int n){
		adj = new int[n][n];
		vertices = n;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				adj[i][j] = 0;
			}
		}
	} 

	public void insertEdge(int i, int j){
		adj[i][j] = 1;
	}

	public void deleteEdge(int i, int j){
		adj[i][j] = 0;
	}

	public boolean isEdge(int i, int j){
		if(adj[i][j] == 1){
			return true;
		}
		return false;
	}

	public boolean is_sink(int i){
		for(int j=0; j<vertices; j++){
			if(adj[i][j] == 1){
				return false;
			}
			if(j!=i && adj[j][i] == 0){
				return false;
			}
			return true;
		}
		return false;
	}

	public void sink(){
		int i=0;
		int j=0;
		while(i<vertices && j<vertices){
			if(adj[i][j] == 1){
				i++;
			}
			if(adj[i][j] == 0){
				j++;
			}
		}
		if(i > vertices){
			System.out.println("no universal edge");
		}
		else if(is_sink(i) == false){
			System.out.println("no universal sink");
		}
		else{
			System.out.println("universal sink is " + i);
		}
	}

	public void bfsDistance(int src){
		Queue q = new Queue();
		boolean[] visited = new boolean[vertices];
		int[] distance = new int[vertices];

		for(int i=0; i<vertices; i++){
			visited[i] = false;
			distance[i] = 10000;
		}
		visited[src] = true;
		distance[src] = 0;
		q.push(src);
		while(!q.isEmpty()){
			int u = q.pop();
			for(int i=0; i<vertices;i++){
				if(visited[u][i]){
					continue;
				}
				distance[adj[u][i]] = distance[u] + 1;
				q.push(adj[u][i]);
				visited(adj[u][i]) = true;
			}
		}
		return distance[v];
	}
}
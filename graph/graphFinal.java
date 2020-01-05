import java.util.Scanner;
import java.util.ArrayList; 

class Queue{
	class Node{
        public int data;
        public Node link;

        Node(){             // simple node
            data =0;
            link = null;
        }

        Node(int n){        //a node with a given value
            data = n;
            link = null;
        }

        Node(int n, Node p){   // node with given value and refernce
            data = n;
            link = p;
        }
        public void setLink(Node n){
            link = n;
        }

        public void setData(int d){
            data = d;
        }

        public Node getLink(){
            return link;
        }

        public int getData(){
            return data;
        }
    }
    public static Node Front = null;
    public static Node Rear = null;
    public static int size;

    public void enqueue(int val){
    	Node nptr = new Node(val);
    	if(Rear == null){
    		Front = nptr;
    	}
    	else{
    		Rear.setLink(nptr);
    	}
    	Rear = nptr;
    	size++;
    }

    public int dequeue(){
    	int d = Front.getData();
    	Front = Front.getLink();
    	if(Front == null){
    		Rear = null;
    	}
    	size--;
    	return d;
    }

    public boolean isEmpty(){
    	if(size <= 0){
    		return true;
    	}
    	return false;
    }
}

class Stack{
    class Node{
        public int data;
        public Node link;

        Node(){             // simple node
            data =0;
            link = null;
        }

        Node(int n){        //a node with a given value
            data = n;
            link = null;
        }

        Node(int n, Node p){   // node with given value and refernce
            data = n;
            link = p;
        }
        public void setLink(Node n){
            link = n;
        }

        public void setData(int d){
            data = d;
        }

        public Node getLink(){
            return link;
        }

        public int getData(){
            return data;
        }
    }
    public Node top = null;
    public int size;

    public void push(int value){
        Node nptr = new Node(value);
        nptr.setLink(top);
        top = nptr;
        size++;
    }

    public int pop(){
        int val = top.getData();
        top = top.getLink();
        size--;
        return val;
    }

    public int getTop(){
        // without removing top
        return top.getData();
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        if(size <= 0){
            return true;
        }
        return false;
    }
}

class Graph{
	public ArrayList<Integer> adj[];	
	public int vertices;

	public Graph(int n){
		adj = new ArrayList[n+1];
		vertices = n + 1;
		for(int i=0; i<=n; i++){
			adj[i] = new ArrayList<Integer>();
		}
	}

	public void addEdge(int i, int j){
		adj[i].add(j);
	}

	public void bfs(){
		Queue q = new Queue();
		boolean[] visited = new boolean[vertices];
		for(int i=0; i<vertices; i++){
			visited[i] = false;
		}
		visited[src] = true;
		q.push(src);
		while(!q.isEmpty()){
			int u = q.pop();
			System.out.println(u);
			for(int i=0; i<adj[u].size(); i++){
				if(!visited[adj[u].get(i)]){
					visited[adj[u].get(i)] = true;
					q.push(adj[u].get(i));
				}
			}
		}
	}

	public int bfsDistance(int src, int dest){
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
			// System.out.println(u);
			for(int i=0; i<adj[u].size(); i++){
				if(!visited[adj[u].get(i)]){
					visited[adj[u].get(i)] = true;
					distance[adj[u].get(i)] = distance[u] + 1;
					if(adj[u].get(i) == dest){
						return distance[adj[u].get(i)];
					}
					q.push(adj[u].get(i));
				}
			}
		}
		return -1;
	}

	public boolean connected(int src, int dest){
		Queue q = new Queue();
		boolean[] visited = new boolean[vertices];
		for(int i=0; i<vertices; i++){
			visited[i] = false;
		}
		visited[src] = true;
		q.push(src);
		while(!q.isEmpty()){
			int u = q.pop();
			// System.out.println(u);
			for(int i=0; i<adj[u].size(); i++){
				if(!visited[adj[u].get(i)]){
					if(visited[adj[u].get(i)] == dest){
						return true;
					}
					visited[adj[u].get(i)] = true;
					q.push(adj[u].get(i));
				}
			}
		}
		return false;
	}

	public void all_paths(int src, int dest){
		Queue q = new Queue();
		boolean[] visited = new boolean[vertices];
		// int[] distance = new int[vertices];
		int[] parent = new int[vertices];

		for(int i=0; i<vertices; i++){
			visited[i] = false;
			distance[i] = 10000;
		}
		visited[src] = true;
		distance[src] = 0;
		q.push(src);

		while(!q.isEmpty()){
			int u = q.pop();
			// System.out.println(u);
			for(int i=0; i<adj[u].size(); i++){
				if(!visited[adj[u].get(i)]){
					visited[adj[u].get(i)] = true;
					parent[adj[u].get(i)] = u;
					q.push(adj[u].get(i));
				}
			}
			while(dest != src){
				System.out.print(src);
				System.out.println(parent[dest]);
			}
		}
	}

	public boolean bipartite(){
		Queue q = new Queue();
		boolean[] visited = new boolean[vertices];
		int[] colour = new int[vertices];
		for(int i=0; i<vertices; i++){
			colour[i] = 0;
		}
		colour[src] = 1;

		for(int i=0; i<vertices; i++){
			visited[i] = false;
		}
		visited[src] = true;
		q.push(src);

		while(!q.isEmpty()){
			int u = q.pop();
			System.out.println(u);
			for(int i=0; i<adj[u].size(); i++){
				if(!visited[adj[u].get(i)]){
					if(colour[adj[u].get(i)] == 0){
						if(colour[u] == 1){
							colour[adj[u].get(i)] = 2;
						}
						else{
							colour[adj[u].get(i)] = 1;	
						}
						visited[adj[u].get(i)] = true;
						q.push(adj[u].get(i));
					}
					else if(colour[u] == colour[adj[u].get(i)]){
						return false;
					}
				}
			}
		}
		return true;	
	}

	public void dfsCycle(){
		int[] colour = new int[vertices];
		for(int i=0; i<vertices; i++){
			colour[i] = 0;
		}
		int time = 0;
		for(int i=1; i<vertices && !flag; i++){			
			if(colour[i] == 0){
				dfs_CycleRecur(i, colour);
			}
		}
	}

	public void dfs_CycleRecur(int u, int[] colour){
		colour[u] = 1;
		for(int i=0; i<adj[u].size() && !flag; i++){
			if(colour[adj[u].get(i)] == 0){
				dfs_CycleRecur(adj[u].get(i), colour);
			}
			else{
				flag = true;
				break;
			}
		}
		colour[u] = 0;
	}

	public int find(int[] parent, int i){
		if(parent[i] == -1){
			return i;
		}
		else{
			return find(parent, parent[i]);
		}
	}

	public void union(int[] parent, int x, int y){
		if(find(parent, x) != find(parent, y)){
			unify();
		}
	}

	public void unify(int[] parent, int x, int y){
		int xPart = find(parent, x);
		int yPart = find(parent, y);
		parent[xPart] = yPart;
	}

	public cycleUsingSets(Graph graph){
		int[] parent = new int[vertices];
		for(int i=0; i<vertices; i++){
			parent[i] = -1;
		}
		
	}
}

class graphFinal{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		Graph g = new Graph(n);	

		for(int i=0; i<m; i++){
			int x = s.nextInt();
			int y = s.nextInt();
			g.addEdge(x, y);
		}

		g.bfs();
	}
}



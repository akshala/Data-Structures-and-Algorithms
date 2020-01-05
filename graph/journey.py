class Graph:
	def __init__(self, n):
		self.vertices=n
		self.graph={}
		self.incomingGraph={}

	def addEdge(self, u, v):
		if u in self.graph.keys() and v not in self.graph.values():
			self.graph[u].append(v)
		else:
			self.graph[u]=[v]

	def remainingEdge(self):
		for vertex in range(0, self.vertices):
			if vertex not in self.graph:
				self.graph[vertex]=[]

	def bfs_distance(self, src, distance, visited):
		q = []
		visited = []
		distance = []
		for i in range(0, self.vertices):
			visited.append(False)
			distance.append(0)
		visited[src] = True
		distance[src] = 0
		prob[src] = 1
		q.append(src)
		while(len(q) > 0):
			u = q.pop();
			for neighbour in self.graph[u]:
				if(not visited[neighbour]):
					distance[neighbour] = 1 + distance[u]
					visited[neighbour] = True
					prob[neighbour] = prob[u]/len(graph[u])
					q.append(neighbour)


n = int(input())
g = Graph(n+1)
for i in range(0,n):
	a = input()
	a = list(map(int, a.split()))
	u = a[0]
	v = a[1]
	g.addEdge(u, v)


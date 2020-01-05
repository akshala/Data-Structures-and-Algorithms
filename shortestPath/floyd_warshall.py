class Graph:
	def __init__(self,n):
		self.vertices = n;
		self.distance = [[100000000] * self.vertices for i in range(self.vertices)]
		for i in range(0,n):
			distance[i][i] = 0

	def addEdge(self,u,v,w):
		self.distance[u][v] = w

	def floyd_warshall(self):
		# shortest path between all pairs of vertices, works for negative + positive edge weights
		for k in range(0, self.vertices):
			for i in range(0, self.vertices):
				for j in range(0, self.vertices):
					distance[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

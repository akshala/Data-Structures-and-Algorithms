class Graph:
	def __init__(self, n):
		self.vertices=n
		self.graph=[]

	def addEdge(self, u, v, w):
		graph.append([u,v,w])

	def bellmanFord(self, src):
		# works for negative + positive edge weights
		distance = [100000000] * self.vertices
		distance[src] = 0
		negative_weight_cycle = False
		for i in range(0, self.vertices-1):
			for(u,v,w) in self.graph:
				if distance[v] > distance[u] + w:
					distance[v] = distance[u] + w

		for (u,v,w) in self.graph:
				if distance[v] > distance[u] + w:
					negative_weight_cycle = True

class Graph:
	def __init__(self, n):
		self.vertices=n
		self.graph={}

	def addEdge(self, u, v, w):
		if u in self.graph.keys():
			self.graph[u].append((v,w))
		else:
			self.graph[u]=[(v,w)]

	def topologicalSort_recur(self, visited, finished, vertex):
		visited[vertex] = True
		for (neighbour, weight) in self.graph[vertex]:
			if(not visited[neighbour]):
				self.topologicalSort_recur(visited, finished, neighbour)
		finished.insert(0,vertex)

	def shortestPath(self, src):
		visited = [False] * self.vertices
		finished = []
		for vertex in range(0, self.vertices):
			if(len(self.graph[vertex]) == 0):
				visited[vertex] = True
				finished.insert(0,vertex)
			else:
				if(not visited[vertex]):
					self.topologicalSort_recur(visited, finished, src)
		distance = [100000000] * self.vertices
		distance[src] = 0
		while(len(finished) > 0):
			u = finished.pop(0)
			for (v,w) in self.graph[u]:
				if distance[v] > distance[u] + w:
					distance[v] = distance[u] + w

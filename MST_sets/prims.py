import heapq 

class Graph:
	def __init__(self, n):
		self.vertices=n
		self.graph={}

	def addEdge(self, u, v, w):
		if u in self.graph.keys() and v not in self.graph.values():
			self.graph[u].append((v,w))
		else:
			self.graph[u]=[(v,w)]

	def prims(self, src):
		distance = [100000000] * self.vertices
		visited = [False] * self.vertices
		parent = [None] * self.vertices
		distance[src] = 0
		visited[src] = True
		minHeap = []
		for i in range(0, self.vertices):
			heapq.heappush(minHeap, (distance[i], i))
		vertex = heapq.heapPop(minHeap)
		for neighbour, weight in self.graph[vertex]:
			if weight < distance[neighbour]:
				parent[neighbour] = vertex
				distance[neighbour] = weight
				heapq.heapify(minHeap)



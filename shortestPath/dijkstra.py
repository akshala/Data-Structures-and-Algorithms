import heapq 

class Graph:
	def __init__(self, n):
		self.vertices = n
		self.graph = {}

	def addEdge(self, u, v, w):
		if u in self.graph.keys():
			self.graph[u].append((v,w))
		else:
			self.graph[u]=[(v,w)]

	def dijkstra(self, src, dest):
		distance = [100000000] * self.vertices
		visited = [False] * self.vertices
		distance[src] = 0
		visited[src] = True
		minHeap = []
		heapq.heappush(minHeap, (0, src))
		while(len(minHeap > 0)):
			dist, vertex = heapq.heapPop(minHeap)
			if vertex == dest:
				return dist
			if(!visited[vertex]):
				for neighbour, weight in self.graph(vertex):
					if distance[neighbour] > distance[vertex] + weight:
						distance[neighbour] = distance[vertex] + weight
						if neighbour == dest:
							return ditance[neighbour]
						heapq.heappush(minHeap, (distance[neighbour], neighbour))



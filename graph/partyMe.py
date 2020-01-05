class Graph:
	def __init__(self, n):
		self.vertices=n
		self.graph={}
		self.incomingGraph={}

	def addEdge(self, u, v):
		# outgoing edges
		if u in self.graph.keys() and v not in self.graph.values():
			self.graph[u].append(v)
		else:
			self.graph[u]=[v]

	def remainingEdge(self):
		for vertex in range(0, self.vertices):
			if vertex not in self.graph:
				self.graph[vertex]=[]

	def party(self, src, visited, distance):
		q = []
		visited[src] = True
		distance[src] = 1
		q.append(src)
		while(len(q) > 0):
			u = q.pop()
			for neighbour in self.graph[u]:
				visited[neighbour] = True
				q.append(neighbour)
				if(distance[src]+1 > distance[i]):
					distance[i] = distance[src]+1

n = int(input())
g = Graph(n+1)
for i in range(0, n):
	p = int(input())
	if p!= -1:
		g.addEdge(p, i-1)
	g.remainingEdge()

visited = []
distance = []
for i in range(0, n):
	visited.append(False)
	distance.append(0)
for i in range(0,n):
	if(not visited[i]):
		g.party(i, visited, distance)
ans = max(distance)
print(ans)

	
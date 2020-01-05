class Graph:
	def __init__(self, n):
		self.vertices=n
		self.graph={}
		self.incomingGraph={}
		self.ans = 0

	def addEdge(self, u, v):
		if u in self.graph.keys() and v not in self.graph.values():
			self.graph[u].append(v)
		else:
			self.graph[u]=[v]

	def remainingEdge(self):
		for vertex in range(0, self.vertices):
			if vertex not in self.graph:
				self.graph[vertex]=[]

	def journey_call(self):
		visited = []
		for i in range(0, self.vertices):
			visited.append(False)
		journey(0, 0, 1, visited)

	def journey(self, vertex, distance, prob, visited):
		print("yes")
		visited[vertex] = True
		children = 0
		for neighbour in self.graph[u]:
			if(not visited[neighbour]):
				children += 1
				print(children)
		for neighbour in self.graph[u]:
			if(not visited[neighbour]):
				journey(neighbour, distance + 1, prob/children, visited)
		if(children == 0):
			print(ans)
			self.ans += p*d

n = int(input())
g = Graph(n+1)
for i in range(0,n-1):
	a = input()
	a = list(map(int, a.split()))
	u = a[0]
	v = a[1]
	g.addEdge(u, v)
g.journey_call
print(g.ans)

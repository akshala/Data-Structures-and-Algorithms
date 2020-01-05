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
		# if v in self.graph.keys() and u not in self.graph.values():
		# 	self.graph[v].append(u)
		# else:
		# 	self.graph[v]=[u]
		# print(self.graph)

	def incomingEdges(self, u, v):
		# incoming edges
		if v in self.incomingGraph.keys() and u not in self.incomingGraph.values():
			self.incomingGraph[v].append(u)
		else:
			self.incomingGraph[v]=[u]
		# print(self.incomingGraph)

	def indegree(self):
		indegree = {}
		# print(self.incomingGraph)
		for vertex in self.incomingGraph.keys():
			# print(vertex)
			# print(self.incomingGraph[vertex])
			indegree[vertex] = len(self.incomingGraph[vertex])
		# print(indegree)
		return indegree

	def remainingEdge(self):
		for vertex in range(1, self.vertices + 1):
			if vertex not in self.graph:
				self.graph[vertex]=[]

	def remaining_incomingEdge(self):
		for vertex in range(1, self.vertices + 1):
			if vertex not in self.incomingGraph:
				self.incomingGraph[vertex]=[]

	def topological_indegree(self):
		flag = 1
		finished = []
		indegree = self.indegree()
		print(indegree)
		for vertex in indegree:
			if(indegree[vertex] == 0):
				flag = 0
				finished.append(vertex)
		# print(finished)
		topologicalOrder = []
		while(len(finished) > 0):
			print(finished)
			vertex = finished.pop(0)
			print(vertex)
			topologicalOrder.append(vertex)
			for neighbour in self.graph[vertex]:
				indegree[neighbour] -= 1
				# print(indegree)
				if(indegree[vertex] == 0):
					flag = 0
					finished.append(vertex)

		if(flag == 1):
			print("no topological order")
		else:
			print("topologicalOrder")

a = input()
a = list(map(int, a.split()))
n = a[0]
m = a[1]
g = Graph(n)
for i in range(0,m):
	b = input()
	b = list(map(int, b.split()))
	x = b[0]
	y = b[1]
	# print(x,y)
	g.addEdge(x,y)
	g.incomingEdges(x,y)
g.remainingEdge()
g.remaining_incomingEdge()
g.topological_indegree()
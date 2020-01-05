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

	# def party(self):
	# 	visited = []
	# 	distance = []
	# 	for i in range(0, self.vertices):
	# 		visited.append(False)
	# 		distance.append(0)
	# 	for i in range(0,self.vertices):
	# 		if(not visited[i]):
	# 			self.party_recur(i, visited, distance)
	# 	return max(distance)

	# def party_recur(self, src, visited, distance):
	# 	q = []
	# 	visited[src] = True
	# 	distance[src] = 1
	# 	q.append(src)
	# 	while(len(q) > 0):
	# 		u = q.pop()
	# 		for neighbour in self.graph[u]:
	# 			if(not visited[i]):
	# 				visited[neighbour] = True
	# 				q.append(neighbour)
	# 				distance[i] += 1

	def party(self):
		visited = []
		distance = []
		for i in range(0, self.vertices):
			visited.append(False)
			distance.append(0)
		for i in range(0, self.vertices):
			if(not visited[i]):
				distance[i] = 1
				self.bfs_distance(i, distance, visited)
		return max(distance)

	def bfs_distance(self, src, distance, visited):
		q = []
		visited[src] = True
		q.append(src)
		while(len(q) > 0):
			u = q.pop();
			for neighbour in self.graph[u]:
				if(not visited[neighbour]):
					distance[neighbour] = 1 + distance[u]
					visited[neighbour] = True
					q.append(neighbour)

n = int(input())
g = Graph(n+1)
for i in range(0, n):
	p = int(input())
	if p!= -1:
		g.addEdge(p, i-1)
g.remainingEdge()
ans = g.party()
print(ans + 1)

	
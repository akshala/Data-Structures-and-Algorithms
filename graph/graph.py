from itertools import combinations
allPaths = []
found = False

class Graph:
	def __init__(self, n):
		self.vertices=n
		self.graph={}
		self.incomingGraph={}

	def addEdge(self, u, v):
		# outgoing edges
		if u in self.graph.keys():
			self.graph[u].append(v)
		else:
			self.graph[u]=[v]
		if v in self.graph.keys():
			self.graph[v].append(u)
		else:
			self.graph[v]=[u]
		# print(self.graph)

	def incomingEdges(self, u, v):
		# incoming edges
		if v in self.incomingGraph.keys():
			self.incomingGraph[v].append(u)
		else:
			self.incomingGraph[v]=[u]

	def indegree(self):
		indegree = {}
		for vertex in incomingGraph:
			indegree[vertex] = len(incomingGraph[vertex])
		return indegree

	def remainingEdge(self):
		for vertex in range(0, self.vertices):
			if vertex not in self.graph:
				self.graph[vertex]=[]

	def all_paths(self):
		verticesList = []
		for i in range(1,n+1):
			verticesList.append(i)
		pairs = list(combinations(verticesList, 2))
		for element in pairs:
			visited=[]
			for i in range(0, self.vertices):
				visited.append(False)
			src = element[0]
			dest = element[1]
			found = False
			result = self.all_paths_recur(src, dest, [], visited)
			allPaths.append(result)

	def all_paths_recur(self, src, dest, path, visited):
		global found
		path.append(src)
		visited[src]=True
		if(src==dest):
			return [src]
		else:
			for element in self.graph[src]: 
				if(not visited[element]): 
					result = self.all_paths_recur(element,dest,path,visited)
					if(result):
						return [src]+result
		return []

	def bfs(self, src, dest):
		q = []
		visited = []
		visited = [False] * self.vertices
		visited[src] = True
		q.append(src)
		while(len(q) > 0):
			u = q.pop(0)
			print(u)
			for neighbour in self.graph[u]:
				if(not visited[neighbour]):
					visited[neighbour] = True
					q.append(neighbour)

	def bfs_distance(self, src, dest):
		q = []
		visited = []
		distance = []
		visited = [False] * self.vertices
		distance = [100000] * self.vertices
		distance[src] = 0
		visited[src] = True
		q.append(src)
		while(len(q) > 0):
			u = q.pop(0);
			print(u)
			for neighbour in self.graph[u]:
				if(not visited[neighbour]):
					distance[neighbour] = 1 + distance[u]
					if(neighbour == dest):
						return distance[neighbour]
					visited[neighbour] = True
					q.append(neighbour)
		return -1

	def dfs(self, dest):
		visited = [False] * self.vertices
		for i in range(0, self.vertices):
			if(not visited[i]):
				self.dfs_recur(i, dest, visited)

	def dfs_recur(self, src, dest, visited):
		print(src)
		visited[src] = True
		for neighbour in self.graph[u]:
			if(not visited[neighbour]):
				if(neighbour == dest):
					return
				else:
					self.dfs_recur(src, dest, visited)

	def connectedComponents(self):
		visited = []
		visited = [False] * self.vertices
		for vertex in range(0, self.vertices):
			if(not visited[vertex]):
				self.connected_recur(vertex, visited)
				print()

	def connected_recur(self, vertex, visited):
		print(vertex, end = " ")
		visited[vertex] = True
		for neighbour in self.graph[vertex]:
			if(not visited[neighbour]):
				self.connected_recur(neighbour, visited)


	def topologicalSort(self):
		visited = []
		for i in range(0, self.vertices):
			visited.append(False)
		finished = []
		for vertex in range(0, self.vertices):
			if(len(self.graph[vertex]) == 0):

				visited[vertex] = True
				finished.insert(0,vertex)
			else:
				if(not visited[vertex]):
					self.topologicalSort_recur(visited, finished, vertex)
		print(finished)

	def topologicalSort_recur(self, visited, finished, vertex):
		visited[vertex] = True
		for neighbour in self.graph[vertex]:
			if(not visited[neighbour]):
				self.topologicalSort_recur(visited, finished, neighbour)
		finished.insert(0,vertex)

	def topological_indegree(self):
		flag = 1
		finished = []
		indegree = self.indegree()
		for vertex in self.indegree:
			if(indegree[vertex] == 0):
				flag = 0
				finished.append(vertex)
		topologicalOrder = []
		while(len(finished) > 0):
			u = finished.pop(0)
			topologicalOrder.append(u)
			for neighbour in self.graph[vertex]:
				indegree[neighbour] -= 1
				if(indegree[vertex] == 0):
					flag = 0
					finished.append(vertex)

		if(flag == 1):
			print("no topological order")
		else:
			print(finished)


# g = Graph(6) 
# g.addEdge(5, 2)
# g.addEdge(5, 0) 
# g.addEdge(4, 0) 
# g.addEdge(4, 1) 
# g.addEdge(2, 3) 
# g.addEdge(3, 1) 
# g.remainingEdge()
  
# # print "Following is a Topological Sort of the given graph"
# g.topological_indegree() 
g = Graph(5); 
g.addEdge(1, 0) 
g.addEdge(2, 3) 
g.addEdge(3, 4) 
g.connectedComponents()
g.all_paths()







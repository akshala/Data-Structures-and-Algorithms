class Graph:
	def __init__(self, n):
		self.vertices=n
		self.graph=[]
		self.array = []
		self.size = []

	def addEdge(self, u, v, w):
		graph.append([w,u,v])

	def initialise(self):
		for i in range(0,self.vertices):
			self.array[i] = i
			self.size = 0

	def root(self, a):
		while a != array[a]:
			array[a] = array[array[a]]
			a = array[a]
		return a

	def union(self, a, b):
		a_root = root(array, a);
		b_root = root(array, b);
		if (size[a_root] > size[b_root]):
			array[b_root] = array[a_root];
			size[a_root] += size[b_root];
		else:
			array[a_root] = array[b_root];
			size[b_root] += size[a_root];

	def kruskals(self):
		mst = []
		edges = sorted(self.graph)
		count = 0
		self.initialise()
		while (count <= self.vertices-1):
			curr = edges[count]
			w,u,v = curr[0], curr[1], curr[2]
			if (self.root(array, u) != self.root(array, v)):
				mst.append(curr)
				self.union(array, size, u, v)
				count += 1

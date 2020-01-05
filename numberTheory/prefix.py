class TreeNode(object):

	def __init__(self):
		self.children = {}

	def add(self, prefix):
		if prefix not in self.children:
			self.children[prefix] = TreeNode()
		return self.children

	def num(self):
		return len(self.children)

	def get(self, prefix):
		return self.children[prefix]

class PrefixTree(object):
	def __init__(self, words):
		self.root = TreeNode()
		for word in words:
			self.add(word)

	def add(self,word):
		node = self.root
		for c in word:
			node = node.add(c)

	def get(self,word):
		node = self.root
		counts = []
		for c in word:
			counts.insert(0, node.num())
			node = node.get(c)
		num_remove = 0
		for count in counts:
			if count != 1:
				break
			num_remove += 1
		return word[:-num_remove] if num_remove > 0 else word
class Solution:
	def prefix(self, A):
		tree = PrefixTree(A)
		return [tree.get(a) for a in A]
class Node:
	def __init__(self):
		self.children = [None]*26
		self.end_word = False

	def set_end(self):
		self.end_word = True

	def is_end(self):
		return self.end_word

	def get_key(self, s):
		return self.children[ord(s) - ord('a')]

	def has_key(self, s):
		if self.children[ord(s) - ord('a')] == None:
			return False
		return True

	def add_key(self, s):
		if self.children[ord(s) - ord('a')] == None:
			self.children[ord(s) - ord('a')] = s

class Trie:
	def __init__(self):
		self.root = Node()

	def insert(self, word):
		curr = self.root
		for letter in word:
			if(not curr.has_key(letter)):
				curr.add_key(letter)
			curr = curr.get_key(letter)
		curr.set_end()

	def search(self, word):
		curr = self.root
		for letter in word:
			if(not curr.has_key(letter)):
				return False
			curr = curr.get_key(letter)
		if(curr.is_end()):
			return True
		return False

	def starts_with(word):
		curr = self.root
		for letter in word:
			if(not curr.has_key(letter)):
				return False
			curr = curr.get_key(letter)
		return True

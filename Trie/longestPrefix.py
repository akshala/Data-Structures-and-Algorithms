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
		for i in range(0,len(word)):
			if(!curr.has_key(words[i])):
				curr.add_key(word[i])
			curr = curr.get_key(word[i])
		curr.set_end()

	def search(self, word):
		curr = self.root
		for i in range(0,len(word)):
			if(!curr.has_key(word[i])):
				return False
			curr = curr.get_key(word[i])
		if(curr.is_end()):
			return True
		return False

	def starts_with(self, word):
		curr = self.root
		for i in range(0,len(word)):
			if(!curr.has_key(word[i])):
				return False
			curr = curr.get_key(word[i])
		return True

	def find_prefix(self, word):
		prefix = ''
		curr = self.root
		for i in range(len(word)):
			if (len(curr.children) == 1) and (curr.has_key(word[i])) and (curr.is_end() == False):
				prefix += word[i]
				curr = curr.children[0]
		return prefix

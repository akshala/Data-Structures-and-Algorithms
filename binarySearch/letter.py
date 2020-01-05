a = input()
num = list(map(int, a.split()))
n = num[0]
m = num[1]
b = input()
d = list(map(int, b.split()));
c = input()
r = list(map(int, c.split()));
s = 0
j = 0
for i in r:
	while(i > s):
		s += d[j]
		j += 1
	print(j, i - (s-d[j-1]))

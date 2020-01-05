import numpy as np

n = int(input())
a = input()
a = list(map(int, a.split()))
m = int(input())
q = input()
q = list(map(int, q.split()))

p = np.cumsum(a)

for i in range(0,m):
	start = 1
	end = n
	result = n
	while(start <= end):
		mid = (start + end)//2
		if(p[mid] >= q[i]):
			result = min(result, mid)
			end = mid - 1
		else:
			start = mid + 1
	if(result == 1):
		print(1)
	else:
		print(result + 1)

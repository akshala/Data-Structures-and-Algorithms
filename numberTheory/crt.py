def crt(num, remainder, k):
	x = 1
	while(True):
		j = 0
		while(j < k):
			if(x % num[j] == rem[j]):
				break
			j += 1
		if(j == k):
			return x
		x += 1
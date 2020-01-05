def multiplicativeInverse(a, m):
	m0 = m
	x0 = 0 
	x1 = 1
	if(m == 1):
		return 0
	else:
		while(a > 1):
			q = a//m
			t = m
			m = a % m
			a = t
			t = x0
			x0 = x1 - q*x0
			x1 = t
			if(x1 < 0):
				x1 = x1 + m0
			return x1

def crt(num, remainder, k):
	product = 1
	for i in range(0,k):
		product *= num[i]
	result = 0
	for i in range(0,k):
		pp = product//num[i]
		result = result + rem[i]*multiplicativeInverse(pp, num[i])*pp
		return result % product
	
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


def naive(a, m):
	# O(m)
	a = a % m
	for i in range(0,m):
		if((a*i) % m == 1):
			return i
	return 1


# if m is prime
# O(log m)

def modInverse(a, m) :  
    g = gcd(a, m)  
    if (g != 1) : 
        print("Inverse doesn't exist")      
    else : 
        print("Modular multiplicative inverse is ", power(a, m - 2, m)) 
      
# To compute x^y under modulo m 
def power(x, y, m) : 
    if (y == 0) : 
        return 1
    p = power(x, y // 2, m) % m 
    p = (p * p) % m 
    if(y % 2 == 0) : 
        return p  
    else :  
        return ((x * p) % m) 
  
# Function to return gcd of a and b 
def gcd(a, b) : 
    if (a == 0) : 
        return b   
    return gcd(b % a, a) 



fib_num = {}

def fibonacci(n):
	if n in fib_num:
		return fib_num[n]
	else:
		if(n <= 2):
			fib_num[n] = 1
			return 1
		else:
			num = fibonacci(n-1) + fibonacci(n-2)
			fib_num[n] = num
			return num

def fibonacci_memo(n):
	for i in range(1,n+1):
		if(i <= 2):
			num = 1
		else:
			num = fibonacci_memo[i-1] + fibonacci_memo[i-2]
		fib_num[i] = num
	return fib_num[n]

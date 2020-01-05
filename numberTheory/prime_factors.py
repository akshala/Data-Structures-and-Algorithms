max_val = 1000*1000*1000+1
upper_limit = int(max_val**0.5) + 1

smallestPF = [i for i in range(0, max_val + 1)]

def buildSieve(): 
    for i in range(2, upper_limit + 1): 
        if (smallestPF[i] == i):           
            for j in range(i * i, max_val + 1, i):  
                if (smallestPF[j] == j): 
                    smallestPF[j] = i 

def primeFactors(num): 
    primeFactorList = [] 
    while (num != 1): 
        primeFactorList.append(smallestPF[num])
        num = num // smallestPF[num] 
    return primeFactorList


buildSieve()
print('Built seive')
x = 600851473
if len(primeFactors(x)) == 2:
    print('Double prime ', x)
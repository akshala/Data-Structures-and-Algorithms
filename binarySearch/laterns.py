a = input()
num = list(map(int, a.split()))
totalLaterns = num[0]
streetLength = num[1]
b = input()
lanterns = list(map(int, b.split()));
lanterns.sort();
# print(lanterns)

dMax = lanterns[0]
flag = 1
# print(streetLength - lanterns[totalLaterns-1])
if(streetLength - lanterns[totalLaterns-1] > dMax):
	dMax = streetLength - lanterns[totalLaterns-1]
	flag = 1
	if(lanterns[totalLaterns - 1] == streetLength):
		flag = 0
		dMax = dMax/2

if(lanterns[0] == 0):
	for i in range(1, totalLaterns):
		# print(dMax)
		if((lanterns[i] - lanterns[i-1])/2 > dMax):
			dMax = (lanterns[i] - lanterns[i-1]) / 2
			flag = 0
else:
	for i in range(2, totalLaterns):
		# print(i)
		# print((lanterns[i] - lanterns[i-1])/2)
		if((lanterns[i] - lanterns[i-1])/2 > dMax):
			dMax = (lanterns[i] - lanterns[i-1])/2
			# print("d", dMax)
			flag = 0
print(dMax)
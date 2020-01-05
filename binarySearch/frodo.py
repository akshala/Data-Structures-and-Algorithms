a = input()
a = list(map(int, a.split()))
totalBeds = a[0]
totalPillows = a[1]
frodo = a[2]
# frodo -= 1
# ans = totalPillows // totalBeds - 
# ans = 1
# if(ans == 0):
# 	ans = 1
# print(ans)
# totalPillows = totalPillows - (ans * totalBeds)
ans = 1
totalPillows -= totalBeds

low = frodo - 1
high = frodo + 1
additional = 1

while(totalPillows > 0):
	# print(totalPillows)
	# print(ans - (totalPillows // totalBeds - 1))
	if(low >= 1):
		additional += 1
	if(high <= totalBeds):
		additional += 1
	totalPillows -= additional
	ans += 1
	low -= 1
	high += 1
	# print(ans)
	# totalPillows -= 1
print(ans)


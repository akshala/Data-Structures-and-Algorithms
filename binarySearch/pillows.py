a = input()
a = list(map(int, a.split()))
totalBeds = a[0]
totalPillows = a[1]
frodo = a[2]
# frodo -= 1
ans = totalPillows // totalBeds - 1
# ans = 1
totalPillows = totalPillows - (ans * totalBeds)
initial = 1
a = 1

while(totalPillows > 0):
	if(frodo + initial <= totalBeds):
		a += 1
	if(frodo - initial >= 1):
		a += 1
	totalPillows -= a
	initial += 1

print(ans + initial)

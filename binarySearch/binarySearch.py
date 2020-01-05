def binarySearch(a, num):
	low = 0
	high = len(a) - 1
	while(low <= high):
		mid = (high + low)//2
		if num == a[mid]:
			return True
		else:
			if num > a[mid]:
				low = mid+1
			else:
				high = mid-1
	return False

print(binarySearch([1,2,3,4,5,6,7,8,9,10], 11))
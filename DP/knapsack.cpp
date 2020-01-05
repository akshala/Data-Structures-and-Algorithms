#include <iostream>
using namespace std;
long long int packing(long long int item, long long int size[], long long int value[], long long int maxSize, long long int n);

int main(){
	long long int maxSize, n;
	cin >> maxSize >> n;
	long long int size[n+1], value[n+1];
	for(long long int j=0; j<n; j++){
		cin >> size[j] >> value[j];
	}
	cout << packing(0, size, value, maxSize, n) << endl;
}

long long int packing(long long int item, long long int size[], long long int value[], long long int maxSize, long long int n){
	if(maxSize == 0){
		return 0;
	}
	if(item == n){
		return 0;
	}
	if(size[item] > maxSize){
		return packing(item + 1, size, value, maxSize, n);
	}
	else{
		// cout << (value[item] + packing(item + 1, size, value, maxSize - size[item], n)) << endl;
		// cout << packing(item + 1, size, value, maxSize, n) << endl;
		return max((value[item] + packing(item + 1, size, value, maxSize - size[item], n)), packing(item + 1, size, value, maxSize, n));
	}
}
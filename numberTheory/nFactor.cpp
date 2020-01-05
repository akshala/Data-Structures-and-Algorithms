#include <iostream>
#include <bits/stdc++.h> 
using namespace std;

int primeNumbers(int start, int end, int n){
	int primes[end + 1];
	memset(primes, 0, sizeof(primes));
	if(n == 0){
		return 1;
	}
	if(end < 2){
		return 0;
	}
	else{		
		for(int i=2; i*i<=end; i++){
			if(primes[i] == 0){
				for(int j=start; j<=end; j+=i){
					primes[j]++;
				}
			}
			primes[i] = 1;
		}
		for(int i=start; i<=end; i++){
			cout << primes[i] << endl;
			if(primes[i] == n){
				return i;
			}
		}
	}
	return 0;
}

int main(){
	int t, start, end, n;
	cin >> t;
	for(int i=0; i<t; i++){		
		cin >> start >> end >> n;
		int final = primeNumbers(start,end,n);
		cout << "f" << final << endl;
	}
}

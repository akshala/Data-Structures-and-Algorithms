#include <iostream>
#include <bits/stdc++.h> 
using namespace std;

const int MAX = 1000000001; 
int factor[MAX] = {0};


void generatePrimeFactor(){
	factor[1] = 1;
	for (int i=2; i<MAX; i++){
		factor[i] = i; 
	} 
	for(int i=4; i<MAX; i++){
		factor[i] = 2;
	}
	for (int i=3; i*i < MAX; i++){
		if(factor[i] == i){
			for (int j = i*i; j<MAX; j += i){
				if(factor[j] == j){
					factor[j] = i;
				}
			}
		}
	}
}

int numFactors(int n){
	if(n == 1){
		return 1;
	}
	int ans = 1;
	int dup = factor[n];
	int c = 1;
	int j = n/factor[n];
	while(j != 1){
		cout << j << endl;
		if(factor[j] == dup){
			c += 1;
		}
		else{
			dup = factor[j];
			ans = ans * (c+1);
			c = 1;
		}
		j = j/factor[j];
	}
	ans = ans * (c+1);
	return ans;
}

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
		for(int i=start; i<end; i++){
			cout << i << " " << numFactors(i) << endl;
			if(numFactors(i) == n){
				return i;
			}
		}
	}
	return 0;
}

int main(){
	int t, start, end, n;
	cin >> t;
	cout << factor[10] << endl;
	for(int i=0; i<t; i++){		
		cin >> start >> end >> n;
		int final = primeNumbers(start,end,n);
		cout << "f" << final << endl;
	}
}

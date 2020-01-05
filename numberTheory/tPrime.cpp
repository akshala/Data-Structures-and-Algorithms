#include <iostream>
#include <bits/stdc++.h> 
using namespace std;

int tPrime(long int x){
	// cout << "0" << endl;
	long double root = sqrt(x);
	if(((root - floor(root)) == 0)){
		int flag = 0;
		long int root = sqrt(x);
		// cout << root << endl;
		for(long int i=2; i<sqrt(root); i++){
			if(root % i == 0){
				flag = 1;
				// cout << "1" << endl;
				// cout << "1" << endl;
				break;
			}
		}
		return flag;
		// cout << "2" << endl;
	}
	return 1;
}

int main(){
	long int n;
	cin >> n;
	long int a[n];
	for(long int i=0; i<n; i++){
		cin >> a[i];
	}
	for(long int i=0; i<n; i++){
		int flag = tPrime(a[i]);
		if(a[i] == 1){
			cout << "NO" << endl;
		}
		else if(flag == 0){
			cout << "YES" << endl;
		}
		else{
			cout << "NO" << endl;
		}
	}
}

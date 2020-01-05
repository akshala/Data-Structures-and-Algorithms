#include <iostream>
#include <bits/stdc++.h> 
using namespace std;

long int gcd(long int a, long int b){
	if(a == 0){
		return b;
	}
	else{
		return gcd(b%a, a);
	}
}

int main(){
	long int n, k;
	long int b = 1;
	cin >> n >> k;
	long int a[n];
	for(long int i=0; i<n; i++){
		cin >> a[i];
		b = (b * a[i]) / gcd(b, a);
		b = gcd(b,k);
		if(b == k){
			cout << "Yes" << endl;
			return 0;
		}
	}
	cout << "No" << endl;
}
#include <iostream>
using namespace std;

int main(){
	long long int t;
	cin >> t;
	for(long long int i=0; i<t; i++){
		long long int n, k;
		cin >> n >> k;
		long long int a[n+1];
		for(long long int j=0; j<n; j++){
			cin >> a[j];
		}
		bool sum[n+1][k+1];
		for(long long int i=0; i<n+1; i++){
			sum[i][0] = true;
		}
		for(long long int i=1; i<=k; i++){
	    	sum[0][i] = false; 
		}
		for(long long int i=1; i<n+1; i++){
			for(long long int j=1; j<k+1; j++){
				if(j<a[i-1]){
					sum[i][j] = sum[i-1][j];
				}
				else{
					sum[i][j] = (sum[i-1][j] || sum[i-1][j-a[i-1]]);
				}
			}
		}
		if(sum[n][k] == true){
			cout << 1 << endl;
		}
		else{
			cout << 0 << endl;
		}
	}
}
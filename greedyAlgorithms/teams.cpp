#include <iostream>
using namespace std;

int main(){
	long long int n, m;
	cin >> n >> m;
	long long int min, max;
	long long int a = n/m;
	min = (m*a*(a-1))/2 + a*(n%m);
	max = ((n-m+1) * (n-m)) / 2;
	cout << min << " " << max << endl;
}
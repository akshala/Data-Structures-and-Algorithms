#include <iostream>
using namespace std;

int gcdExtended(int a, int b, int *x, int *y){
	if(a == 0){
		*x = 0;
		*y = 1;
		return b;
	}
	else{
		int x1, y1;
		int gcd = gcdExtended(b%a, a, &x1, &y1);
		*x = y1 - (b/a) * x1; 
		*y = x1; 
		return gcd; 
	}
}

int main(){
	int a,b;
	cin >> a;
	cin >> b;
	int final = gcd(a,b,&x,&y);
	cout << final << endl;
	return 0;
}

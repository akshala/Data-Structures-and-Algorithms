#include <iostream>
using namespace std;

bool line(long int a, long int b, long int c, long int x, long int y){
	long int result = a*x + b*y + c;
	if(result == 0){
		return true;
	}
	return false;
}

long int gcdExtended(long int a, long int b, long int *x, long int *y){
	if(a == 0){
		*x = 0;
		*y = 1;
		return b;
	}
	else{
		long int x1, y1;
		long int gcd = gcdExtended(b%a, a, &x1, &y1);
		*x = y1 - (b/a) * x1; 
		*y = x1; 
		return gcd; 
	}
}

int main(){
	long int a, b, c, gcd;
	long int x = 0, y = 0;
	cin >> a >> b >> c;
	c = -1 * c;
	gcdExtended(a,b,&x,&y);
	gcd = a*x + b*y;
	if(c % gcd != 0){
		cout << "-1" << endl;
	}
	else{		
		x = c / gcd * x;
		y = c / gcd * y;
		cout << x << " " << y << endl;
	}
	return 0;
}

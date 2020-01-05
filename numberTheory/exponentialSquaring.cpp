#include <iostream>
using namespace std;

long int exponential(long int base, long int power){
	if(power == 0){
		return 1;
	}
	if(power == 1){
		return base % 1000000007;
	}
	else{
		long int t = exponential(base, power/2);
		t = t*t % 1000000007;
		if(power % 2 == 0){
			return t;
		}
		else{
			return ((base % 1000000007)*t) % 1000000007;
		}
	}
}

int main(){
	long int base;
	long int power;
	cin >> base;
	cin >> power;
	long int final = exponential(base, power);
	cout << final << endl;
	return 0;
}


#include <iostream>
using namespace std;

long int exponential(long int base, long int power){
	int long t = 1;
	while(power > 0){
		if(power % 2 != 0){
			t = (t*base) % 1000000007;
		}
		base = (base*base) % 1000000007;
		power /= 2;
	}
	return t % 1000000007;
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
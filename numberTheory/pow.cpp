#include <iostream>
using namespace std;
const double num = 1000000007;

double exponential(double base, double power){
	if(power == 0){
		return 1;
	}
	if(power == 1){
		return base % num;
	}
	else{
		double t = exponential(base, power/2);
		t = t*t % num;
		if(power % 2 == 0){
			return t;
		}
		else{
			return ((base % num)*t) % num;
		}
	}
}

int main(){
	double base;
	double power;
	cin >> base >> power;
	double final = exponential(base, power);
	cout << final << endl;
	return 0;
}


#include <iostream>
#include <bits/stdc++.h> 
using namespace std;

int main(){
	int totalBeds, totalPillows, frodo;
	cin >> totalBeds >> totalPillows >> frodo;
	int ans = 1;
	totalPillows -= totalBeds;
	int low = frodo - 1;
	int high = frodo + 1;
	int additional = 1;
	while(totalPillows > 0){
		if(low == 1 && high == totalBeds){
			ans += (totalPillows / totalBeds);
			totalPillows -= (totalPillows / totalBeds) * totalBeds;
		}
		// cout << totalPillows << endl;
		// else{ 
		if(low >= 1){
			additional += 1;
		}
		if(high <= totalBeds){
			additional += 1;
		}
		totalPillows -= additional;
		ans += 1;
		low -= 1;
		high += 1;
		// }
	}
	cout << ans << endl;
	return 0;
}


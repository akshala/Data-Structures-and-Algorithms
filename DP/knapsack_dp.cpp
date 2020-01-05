#include <iostream>
using namespace std;

int main(){
	long long int maxSize, n;
	cin >> maxSize >> n;
	long long int size[n+1], value[n+1];
	for(long long int j=0; j<n; j++){
		cin >> size[j] >> value[j];
	}
	long long int k[n+1][maxSize+1];
	for(long long int i=0; i<n+1; i++){
		for(long long int w=0; w<maxSize+1; w++){
			if (i==0 || w==0){
				k[i][w] = 0; 
			}
			else{
				if(size[i] > maxSize){
					k[i][w] = k[i-1][w];
				}
				else{
					k[i][w] = max(value[i-1] + k[i-1][w - size[i-1]], k[i-1][w]);
				}
			}
		}
	}
	cout << k[n][maxSize] << endl;
}

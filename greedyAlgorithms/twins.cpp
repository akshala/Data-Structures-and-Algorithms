#include <iostream>
using namespace std;
void quickSort (long long int x[], long long int segmentSize, long long int length);

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
	long long int n;
	cin >> n;
	long long int a[n+1];
	for(long long int j=0; j<n; j++){
		cin >> a[j];
	}
	quickSort(a,n,n);
	long long int sum = 0;
	for(long long int j=0; j<n; j++){
		sum += a[j];
	}
	long long int mine = 0;
	long long int j = 0;
	long long int count = 0;
	while(mine <= sum){
		mine += a[j];
		sum -= a[j];
		j++;
		count++;
	}
	cout << count << endl;
}

void quickSort (long long int x[], long long int segmentSize, long long int length)
{
    if (segmentSize <= 1)
    {
        return;
    }
    long long int temp[length];
    long long int pivot = x[0];
    long long int i = 0, j = segmentSize - 1, num, k;
    for (num = 1; num < segmentSize; num++)
    {
        if (x[num] > pivot)
        {
            temp[i] = x[num];
            i++;
        }
        else
        {
            temp[j] = x[num];
            j--;
        }
    }
    temp[i] = pivot;
    for(k = 0; k < segmentSize; k++)
    {
        x[k] = temp[k];
    }
    quickSort(x, i, length);
    quickSort(x + i + 1, segmentSize - i - 1, length);
    return;
}

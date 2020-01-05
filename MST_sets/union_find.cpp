#include <iostream>
using namespace std;

void initialise(int n){
	int array[n];
	for(int i=0; i<n; i++){
		array[i] = i;
	}
}

void union_basic(int array[], int a, int b, int n){
	for(int i=0; i<n; i++){
		if(array[i] == array[a]){
			array[i] = array[b];
		}
	}
}

bool find(int array[], int a, int b, int n){
	if (array[a] == array[b]) {
		return true;
	}
	return false;
}

int root(int array[], int a){
	while(a != array[a]){
		a = array[a];
	}
	return a;
}

void union_root(int array[], int a, int b, int n){
	int a_root = root(array, a);
	int b_root = root(array, b);
	array[a_root] = b_root;
}

bool find_root(int array[], int a, int b, int n){
	if (root(a) == root(b)) {
		return true;
	}
	return false;
}

void initialise_with_size(int n){
	int array[n];
	int size[n];
	for(int i=0; i<n; i++){
		array[i] = i;
		size[i] = 1;
	}
}

void union_weighted(int array[], int size[], int a, int b, int n){
	int a_root = root(array, a);
	int b_root = root(array, b);
	if (size[a_root] > size[b_root]){
		array[b_root] = array[a_root];
		size[a_root] += size[b_root];
	}
	else{
		array[a_root] = array[b_root];
		size[b_root] += size[a_root];
	}
}

int root_path_compression(int array[], int a){
	while(a != array[a]){
		array[a] = array[array[a]];
		a = array[a]
	}
	return a;
}

int main(){
	initialise(3);
	cout << array[1] << endl;
}
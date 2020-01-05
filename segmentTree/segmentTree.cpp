#include <iostream>
using namespace std;

void build(int tree[], int a[], int node, int start, int end){
	if(start == end){
		tree[node] = a[start];
		return;
	}
	int mid = (start + end)/2;
	build(tree, a, 2*node, start, mid);
	build(tree, a, 2*node + 1, mid+1, end);
	tree[node] = tree[2*node] + tree[2*node + 1];
}

void update(int tree[], int node, int start, int end, int index, int val){
	if(index >= start and index <= mid){
		if(start == end){
			a[node] += value;
			tree[node] += value;
			return;
		}
		int mid = (start + end)/2;
		update(2*node, start, mid, index, value);
		update(2*node + 1, mid+1, end, index, value);
		tree[node] = tree[2*node] + tree[2*node + 1];
	}
}

int query(int tree[], int node, int start, int end, int l, int r){
	if(l > end or r < start){
		return 0;
	}
	if(l <= start and r >= end){
		return tree[node];
	}
	else{
		int mid = (start + end)/2;
		return query(2*node, start, mid, l, r) + query(2*node + 1, mid+1, end, l, r);
	}
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

}

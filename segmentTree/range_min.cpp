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
	if(tree[2*node] < tree[2*node + 1]){
		tree[node] = tree[2*node];
	}
	else{
		tree[node] = tree[2*node + 1];
	}
}

void update(int tree[], int a[], int node, int start, int end, int index, int value){
	int mid = (start + end)/2;
	if(index >= start and index <= mid){
		if(start == end){
			a[node] = value;
			tree[node] = value;
			return;
		}
		update(tree, a, 2*node, start, mid, index, value);
		update(tree, a, 2*node + 1, mid+1, end, index, value);
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
		int query1 = query(tree, 2*node, start, mid, l, r);
		int query2 = query(tree, 2*node + 1, mid+1, end, l, r); 
		if(query1 < query2){
			return query1;
		}
		else{
			return query2;
		}
	}
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int tree[2000005], values[100005];
	int n, q;
	cin >> n >> q;
	for(int i=0; i<n; i++){
		cin >> values[i];
		build(tree, values, 0, 0, i);
	}
	for(int i=0; i<n; i++){
		cout << tree[i] << " ";
	}
	cout << endl;
	for(int i=0; i<q; i++){
		char queryType;
		int a, b;
		cin >> queryType >> a >> b;
		if(queryType == 'q'){
			cout << query(tree, 0, 0, n-1, a-1, b-1) << endl;
		}
		else{
			update(tree, values, 0, 0, n-1, a-1, b-1);
		}
	}
}

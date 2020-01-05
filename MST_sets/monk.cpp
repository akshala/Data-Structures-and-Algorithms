#include <iostream>
#include <vector>
using namespace std;

void friends(int vertex){
	visited[vertex] = true;
	for(int i=0; i<graph[vertex].size; i++){
		if(graph[vertex][i] == false){
			return 1 + friends(graph[vertex][i]);
		}
		return 1;
	}
}

int main(){
	int n, d;
	cin >> n >> d;
	vector<vector<int>> graph;
	bool visited[n];
	for(int i=0; i<d; i++){
		cin >> a >> b;
		graph[a-1].push_back(b-1);
	}
	vector<int> possible_answers;
	for(int i=0; i<n; i++){
		for(int j=0; j<n;j++){
			visited[j] = false;
		}
		possible_answers.push_back(friends(i));
	}
	int min = 100000;
	for(int i=0; i<n; i++){
		if(possible_answers(i) < min){
			min = possible_anwers(i);
		}
	}
	cout << min << endl;
}
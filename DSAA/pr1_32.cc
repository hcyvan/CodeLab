#include <iostream>
#include <bits/stdc++.h>

using namespace std;

template<class T>
void permutations_recursive(T list[], int s, int e) {
    if(s==e) {
        for (int i=0; i<=e; i++) {
            cout << list[i] << " ";
        }
        cout << endl;
    } else {
        for (int i=s; i<e; i++) {
             swap(list[s], list[i]);
             permutations_recursive(list, s+1, e);
            swap(list[s], list[i]);
        }
    }
}

int main() {
    string arr[3] = {"A", "B", "C"};
    permutations_recursive(&arr, 0, 2);
}
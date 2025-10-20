#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n, target;
    cin >> n >> target;
    vector<int> arr(n);
    for(int i=0;i<n;i++) cin >> arr[i];

    sort(arr.begin(), arr.end());
    int i = 0, j = n-1;
    bool found = false;
    while(i < j) {
        int sum = arr[i] + arr[j];
        if(sum == target) {
            cout << "Pair found: " << arr[i] << " " << arr[j] << endl;
            found = true;
            break;
        } else if(sum < target) i++;
        else j--;
    }
    if(!found) cout << "No pair found\n";
}

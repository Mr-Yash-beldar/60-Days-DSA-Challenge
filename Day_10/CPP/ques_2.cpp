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
    bool found = false;
    for(int k=0;k<n-2;k++) {
        int i = k+1, j = n-1;
        while(i < j) {
            int sum = arr[k] + arr[i] + arr[j];
            if(sum == target) {
                cout << "Triplet found: " << arr[k] << " " << arr[i] << " " << arr[j] << endl;
                found = true;
                break;
            } else if(sum < target) i++;
            else j--;
        }
        if(found) break;
    }
    if(!found) cout << "No triplet found\n";
}

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
    int count = 0;
    while(i < j) {
        int sum = arr[i] + arr[j];
        if(sum == target) {
            count++;
            i++;
            j--;
        } else if(sum < target) i++;
        else j--;
    }
    cout << count << endl;
}

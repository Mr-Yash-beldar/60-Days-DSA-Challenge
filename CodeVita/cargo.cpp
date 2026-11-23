#include <bits/stdc++.h>
using namespace std;

/*
Bayland Cargo Optimization Problem
---------------------------------
We must assign cargo ships to minimize total transport cost.
Each goodie (label + weight) is assigned to a ship with the same label.
We can rearrange the ships in any order to minimize cost.

Steps:
1. Read goodies (label, weight)
2. Group total weights per label
3. Try all permutations of unique labels (ships)
4. For each arrangement, calculate cost = sum(weight * distance)
5. Keep track of minimum cost and all arrangements yielding it
6. Sort those arrangements lexicographically
7. Output min cost and Kth arrangement
*/

int main() {
    int N;
    cin >> N;

    vector<pair<string, int>> goodies(N);
    for (int i = 0; i < N; i++) {
        cin >> goodies[i].first >> goodies[i].second;
    }

    int K;
    cin >> K;

    // Step 1: compute total weight for each label
    map<string, long long> labelWeight;
    for (auto &g : goodies) {
        labelWeight[g.first] += g.second;
    }

    // Step 2: store unique ship labels
    vector<string> ships;
    for (auto &x : labelWeight)
        ships.push_back(x.first);

    int M = ships.size();
    vector<int> landPos; // positions of goodies
    for (int i = 0; i < N; i++)
        landPos.push_back(i); // 0-indexed

    long long minCost = LLONG_MAX;
    vector<vector<string>> bestArrangements;

    // Step 3: try all permutations of ships
    sort(ships.begin(), ships.end());
    do {
        long long totalCost = 0;
        // Step 4: calculate cost
        for (int i = 0; i < N; i++) {
            string label = goodies[i].first;
            int shipIndex = find(ships.begin(), ships.end(), label) - ships.begin();
            totalCost += 1LL * goodies[i].second * abs(i - shipIndex);
        }

        if (totalCost < minCost) {
            minCost = totalCost;
            bestArrangements.clear();
            bestArrangements.push_back(ships);
        } else if (totalCost == minCost) {
            bestArrangements.push_back(ships);
        }

    } while (next_permutation(ships.begin(), ships.end()));

    // Step 5: sort lexicographically
    sort(bestArrangements.begin(), bestArrangements.end());

    // Step 6: print result
    cout << minCost << "\n";
    vector<string> res = bestArrangements[K - 1];
    for (int i = 0; i < res.size(); i++) {
        cout << res[i];
        if (i != res.size() - 1)
            cout << " ";
    }
    cout << "\n";

    return 0;
}

#include <iostream>
#include <sstream>
#include <string>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <queue>
using namespace std;

static inline vector<string> split(const string &s)
{
    vector<string> t;
    string w;
    stringstream ss(s);
    while (ss >> w)
        t.push_back(w);
    return t;
}

static bool canTravel(
    const string &src, const string &dst,
    const unordered_map<string, unordered_set<string>> &adj,
    const unordered_map<string, unordered_set<string>> &restricts)
{
    if (src == dst)
        return true;
    auto itS = adj.find(src), itD = adj.find(dst);
    if (itS == adj.end() || itD == adj.end())
        return false;

    const unordered_set<string> emptySet;
    const unordered_set<string> &block =
        (restricts.count(src) ? restricts.at(src) : emptySet);

    unordered_set<string> vis;
    queue<string> q;
    q.push(src);
    vis.insert(src);

    while (!q.empty())
    {
        string u = q.front();
        q.pop();
        auto it = adj.find(u);
        if (it == adj.end())
            continue;
        for (const string &v : it->second)
        {
            if (vis.count(v))
                continue;
            if (v != src && block.count(v))
                continue; // respect restrictions
            if (v == dst)
                return true;
            vis.insert(v);
            q.push(v);
        }
    }
    return false;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    if (!(cin >> N))
        return 0;
    string dummy;
    getline(cin, dummy); // consume eol

    unordered_map<string, unordered_set<string>> adj;

    // read N connection lines
    for (int i = 0; i < N;)
    {
        string line;
        if (!getline(cin, line))
            return 0;
        auto tk = split(line);
        if (tk.empty())
            continue; // skip blanks
        ++i;
        const string &u = tk[0];
        for (size_t j = 1; j < tk.size(); ++j)
        {
            const string &v = tk[j];
            adj[u].insert(v);
            adj[v].insert(u);
        }
        // ensure nodes exist even if isolated later
        adj.emplace(u, adj[u]);
    }

    int Q;
    cin >> Q;
    getline(cin, dummy); // eol

    struct Query
    {
        string a, op, b;
    };
    vector<Query> qs;
    qs.reserve(Q);
    for (int i = 0; i < Q;)
    {
        string line;
        if (!getline(cin, line))
            return 0;
        auto tk = split(line);
        if (tk.empty())
            continue;
        ++i;
        // format: A to B  |  A connects B  |  A disconnects B
        qs.push_back({tk[0], tk[1], tk[2]});
        // make sure nodes exist in adj map for future updates
        adj.emplace(tk[0], unordered_set<string>{});
        adj.emplace(tk[2], unordered_set<string>{});
    }

    int R;
    cin >> R;
    getline(cin, dummy);

    unordered_map<string, unordered_set<string>> restricts;
    for (int i = 0; i < R;)
    {
        string line;
        if (!getline(cin, line))
            return 0;
        auto tk = split(line);
        if (tk.empty())
            continue;
        ++i;
        const string &s = tk[0];
        auto &S = restricts[s];
        for (size_t j = 1; j < tk.size(); ++j)
            S.insert(tk[j]);
        // ensure nodes exist
        adj.emplace(s, unordered_set<string>{});
        for (size_t j = 1; j < tk.size(); ++j)
            adj.emplace(tk[j], unordered_set<string>{});
    }

    for (const auto &q : qs)
    {
        if (q.op == "to")
        {
            if (canTravel(q.a, q.b, adj, restricts))
            {
                cout << "yes" << "\n";
            }
            else
            {
                cout << "no" << "\n";
            }
        }
        else if (q.op == "connects")
        {
            adj[q.a].insert(q.b);
            adj[q.b].insert(q.a);
        }
        else if (q.op == "disconnects")
        {
            auto itA = adj.find(q.a);
            if (itA != adj.end())
                itA->second.erase(q.b);
            auto itB = adj.find(q.b);
            if (itB != adj.end())
                itB->second.erase(q.a);
        }
    }
    return 0;
}
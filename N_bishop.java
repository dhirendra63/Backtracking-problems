class Solution {
    int n;
    int ans = 0;
    void solve(int row, int col, int count, boolean[] diag1, boolean[] diag2) {
        if (count == n) {
            ans++;
            return;
          }
        if (row == n) return;
        if (col == n) {
            solve(row + 1, 0, count, d1, d2);
            return;
            }
        int i = row - col + n - 1;
        int j = row + col;
        if (!diag1[i] && !diag2[j]) {
            diag1[i] = true;
            diag2[j] = true;
            solve(row + 1, 0, count + 1, diag1, diag2);
            diag1[i] = false;
            diag2[j] = false;
        }
        solve(row, col + 1, count, diag1, diag2);
    }
    public int totalWays(int N) {
        n = N;
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        solve(0, 0, 0, diag1, diag2);
        return ans;
    }
}

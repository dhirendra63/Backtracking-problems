class Solution {
  public boolean  helper(int[][]grid,int rowIdx,int colIdx,int num){
        int n=grid.length;
        if(grid[rowIdx][colIdx]==n*n-1) return true;
        int i,j;
        // 2 up 1 right
        i=rowIdx-2;
        j=colIdx+1;
        if(i>=0 && j<n){
            if(grid[i][j]==num+1){
                return helper(grid,i,j,num+1);
            }
        }
        // 2 up 1 left
        i=rowIdx-2;
        j=colIdx-1;
        if(i>=0 && j>=0){
            if(grid[i][j]==num+1){
                return helper(grid,i,j,num+1);
            }
        }
        // 2 down 1 right
        i=rowIdx+2;
        j=colIdx+1;
        if(i<n  &&j<n){
            if(grid[i][j]==num+1){
                return helper(grid ,i ,j ,num+1);
            }
        }
        // 2 down 1 left
        i=rowIdx+2;
        j=colIdx-1;
        if(i<n && j>=0){
            if(grid[i][j]==num+1){
                return helper(grid,i,j,num+1);
            }
        }

        // 2 right 1 up
         i=rowIdx-1;
        j=colIdx+2;
        if(i>=0 && j<n){
            if(grid[i][j]==num+1){
                return helper(grid,i,j,num+1);
            }
        }
        // 2 right 1 down
        i=rowIdx+1;
        j=colIdx+2;
        if(i<n && j<n){
            if(grid[i][j]==num+1){
                return helper(grid,i,j ,num+1);
            }
        }

        // 2 left 1 up
         i=rowIdx-1;
        j=colIdx-2;
        if(i>=0 && j>=0){
            if(grid[i][j]==num+1){
                return helper(grid,i,j, num+1);
            }
        }
        // 2 left 1 down
        i=rowIdx+1;
        j=colIdx-2;
        if(i<n && j>=0){
            if(grid[i][j]==num+1){
                return helper(grid,i,j, num+1);
            }
        }
return false;

    }
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0]!=0) return false;
        return helper(grid,0,0,0);
    }
}

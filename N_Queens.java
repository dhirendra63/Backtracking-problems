class Solution {
    public boolean isSafeToPlace(int n,int rowIdx,int colIdx,char[][]board){
        int row=rowIdx;
        int col=colIdx;
        while(col>=0){
            if(board[row][col]=='Q'){
                return false;
            }
            col--;
        }
        row=rowIdx;
        col=colIdx;
        while(row>=0 && col>=0){
            if(board[row][col]=='Q') return false;
            row-=1;
            col-=1;

        }

        row=rowIdx;
        col=colIdx;
        while(row<n && col>=0){
            if(board[row][col]=='Q') return false;
            row+=1;
            col-=1;
        }
        return true;


    }
    public void solve(int n,int colIdx,char[][]board,List<List<String>> ans){
        if(colIdx>=n){
            List<String>temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for(int rowIdx=0;rowIdx<n;rowIdx++){
            if(isSafeToPlace(n,rowIdx,colIdx,board)){
                board[rowIdx][colIdx]='Q';
                solve(n,colIdx+1,board,ans);
                board[rowIdx][colIdx]='.';
            }
            
        }

    }
    public List<List<String>> solveNQueens(int n) {
       char board[][]=new char[n][n];
       for(int i=0;i<n;i++){
        Arrays.fill(board[i],'.');
       } 
       List<List<String>> ans=new ArrayList<>();
       solve(n,0,board,ans);
       return ans;
    }
}

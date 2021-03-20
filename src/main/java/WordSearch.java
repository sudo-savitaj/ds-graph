public class WordSearch {

    public boolean isWordExist(char[][] board, String word) {
        int rowLength = board.length;
        int colLength = board[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j,visited)) return true;

            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, boolean[][] visited) {
        if (word.isEmpty()) return true;
        if(!isSafe(board,row,col,visited)) return false;
        visited[row][col] = true;

        int[] rowAj = {-1,0,0,1};
        int[] colAj = {0,-1,1,0};
        if(word.charAt(0)!= board[row][col]) return false;
        if(word.length()==1)return true;

        for(int k=0;k<rowAj.length;k++){
            visited[row][col] = true;
            boolean res = dfs(board,word.substring(1),row+rowAj[k],col+colAj[k], visited);
            if(res) return true;
            visited[row][col] = false;
        }

        return false;
    }

    private boolean isSafe(char[][] board, int row, int col, boolean[][] visited) {
        int rowLength = board.length;
        int colLength = board[0].length;
        return row >= 0 && col >= 0 && row < rowLength && col < colLength && !visited[row][col];
    }

    public void display() {
//        char[][] board = {{'a','g','b','c'},{'q','o','e','l'},{'g','b','k','s'}};
//        char[][] board = {{'b','a','c','d','d','b'}};
        char[][] board = {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        boolean res = isWordExist(board,"sabfs");
        System.out.println(res);
    }
}

//a b c e
//s f c s
//a d e e
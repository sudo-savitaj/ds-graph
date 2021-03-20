public class UnitAreaOfLargestRegion {
    void display() {
        int[][] grid = {
                {0, 1, 1, 1},
                {0, 1, 1, 1},
                {0, 0, 1, 1}};

        int area = findMaxArea(grid);

        System.out.println(area);
    }

    int findMaxArea(int[][] grid) {
        int max = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;
        boolean[][] visted = new boolean[rowLength][colLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (!visted[i][j] && grid[i][j] == 1) {
                    int areaCovered = dfs(grid, i, j, visted);
                    if (areaCovered > max) max = areaCovered;
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int row, int col, boolean[][] visted) {
        visted[row][col] = true;

        int[] rowNbr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colNbr = {-1, 0, 1, -1, 1, -1, 0, 1};

        int areaCovered = 1;
        for (int k = 0; k < rowNbr.length; k++) {
            if (isSafe(grid, row + rowNbr[k], col + colNbr[k], visted))
                areaCovered += dfs(grid, row + rowNbr[k], col + colNbr[k], visted);
        }
        return areaCovered;

    }

    private boolean isSafe(int[][] grid, int row, int col, boolean[][] visted) {
        return isWithInGrid(grid, row, col) && grid[row][col] == 1 && !visted[row][col];
    }

    private boolean isWithInGrid(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

}

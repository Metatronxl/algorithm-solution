64. Minimum Path Sum



思路：运用dijkstra算法从`grid[0,0]`开始，逐步的更新`grid[i,j]`的值,最后grid[row-1,col-1]的值即为所求的值

```Java
    public int minPathSum(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        for(int j=1;j<col;j++){
            grid[0][j] += grid[0][j-1];
        }
        for(int i=1;i<row;i++){
            grid[i][0] += grid[i-1][0];
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }

        for(int i=0;i<row;i++){
            System.out.println(Arrays.toString(grid[i]));
        }

        return grid[row-1][col-1];
    }

```



 
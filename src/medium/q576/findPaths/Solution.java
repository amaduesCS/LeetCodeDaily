package medium.q576.findPaths;


/*
* 4^maxMove
*
* */
class Solution {
    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int [][][] memory = new int[m][n][maxMove+1];
        return calMove(m,n,maxMove, startRow, startColumn, memory);
    }

    public static int calMove(int m, int n, int maxMove, int startRow, int startColumn, int[][][]memory){
        if( startRow ==-1 || startColumn ==-1 || startRow == m ||  startColumn == n ){
            return 1;
        }
        if(maxMove == 0 ){
            return 0;
        }
        int moves = 0;
        int finalMove = 0;
        int extraMove = 0;
        if(maxMove > 1){
            calMove(m,n,maxMove-1, startColumn,startColumn, memory);
            for (int i = 1; i < maxMove; i++) {
                moves = moves + memory[startRow][startColumn][i];
            }
        }
        extraMove = calMove(m, n, maxMove-1, startRow + 1, startColumn, memory)
                    + calMove(m, n, maxMove-1, startRow, startColumn + 1, memory)
                    + calMove(m, n, maxMove-1, startRow - 1, startColumn,memory)
                    + calMove(m, n, maxMove-1, startRow, startColumn - 1, memory);

        finalMove =  moves + extraMove;
        memory[startRow][startColumn][maxMove] = finalMove;
        /*int calMoves =  findPaths(m, n, maxMove-1, startRow+1, startColumn)
        + findPaths(m, n,maxMove-1, startRow, startColumn+1)
        + findPaths(m, n, maxMove-1, startRow-1, startColumn)
        + findPaths(m, n,maxMove-1, startRow, startColumn-1);*/
        return finalMove;

    }



    public static void main(String[] args) {
        int paths = findPaths(1, 1, 2, 0, 0);
        System.out.println(paths);

    }
}
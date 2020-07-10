package hw5;

public class sexQueens {
    public static void main(String[] args) {

        int[][] desk = new int[6][6];
        // заполняем массив значениями -1
        for (int i = 0; i < desk.length; i++) {
            for (int j = 0; j < desk[0].length; j++) {
                desk[i][j] = -1;
            }
        }
        queenMove(desk, 0, 1, 1);
        printDesk(desk);
        System.out.println(op);

    }

    private static int[][] kMoves = {
            {2, 1}, {1, 1}
    };
    static int[] arrX = {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] arrY = {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] arrXY = {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static boolean isPossible(int[][] desk, int x, int y) {
        boolean isPoss = true;

        for (int i = 0; i < arrXY.length; i++) {
            if ((x + y) == arrXY[i]) isPoss = false; // проверка на диагонали 45гр
            if (x == y)
                isPoss = false; // проверка на диагонали -45гр (только центральная, логигу других не успел продумать)
            if (x == arrX[i]) isPoss = false; //проверка по оси Х
            if (y == arrY[i]) isPoss = false; //проверка по оси У

        }
        arrX[x] = x;
        arrY[y] = y;
        arrXY[x+y] = x + y;
        return isPoss;
    }

    private static int op = 0;


    private static boolean queenMove(int[][] desk, int currX, int currY, int move) {
        desk[currX][currY] = move;
        if (move > desk.length) return true;
        int nextX, nextY;
        for (int i = 0; i < kMoves.length; i++) {
            op++;
            nextX = currX + kMoves[i][1];

            nextY = currY + kMoves[i][0];
            if (nextY > desk.length - 1) nextY = nextY - desk.length + 1;
            if (isPossible(desk, nextX, nextY) && queenMove(desk, nextX, nextY, move + 1)){
                return true;
            }
        }
//       desk[currX][currY] = 0;
        return false;
    }

    private static void printDesk(int[][] desk) {
        for (int i = 0; i < desk.length; i++) {
            for (int j = 0; j < desk[0].length; j++) {
                System.out.printf("%3d", desk[i][j]);
            }
            System.out.println();
        }
    }
}
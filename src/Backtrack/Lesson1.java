package Backtrack;

public class Lesson1 {
    public static int N = 8;

    public static void main(String[] args) {
        int[][] board = new int[N][N];
        boolean result = solveNQueen(board, 0);
        if (result) {
            System.out.println("Một trong các lời giải: ");
            showResult(board);
        } else {
            System.out.println("Không tìm thấy lời giải nào");
        }
    }

    private static void showResult(int[][] board) {
        for (var row : board) {
            for (var e : row) {
                System.out.printf("%3d", e);
            }
            System.out.println();
        }
    }

    private static boolean solveNQueen(int[][] board, int col) {
        if (col >= N) {
            return true;
        }

        //Kiểm tra cột hiện tại và đặt hậu đúng vị trí
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveNQueen(board, col + 1)) {
                    return true;
                } else {
                    board[i][col] = 0;      //Quay lui
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        //Kiểm tra trên hàng
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        //Kiểm tra đường chéo trên
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        //Kiểm tra đường chéo dưới
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}

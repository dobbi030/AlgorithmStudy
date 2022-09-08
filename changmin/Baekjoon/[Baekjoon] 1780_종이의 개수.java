import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1780 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int boardSize;
    static int[][] board;
    static int[] numSize = { 0, 0, 0 };

    static void recursion(int size, int startY, int startX) {
        int pivot = board[startY][startX];

        if (size == 1) {
            numSize[pivot + 1]++;
            return;
        }

        for (int i = startY; i < startY + size; ++i) {
            for (int j = startX; j < startX + size; ++j) {
                if (board[i][j] != pivot) {
                    recursion(size / 3, startY, startX);
                    recursion(size / 3, startY, startX + (size / 3));
                    recursion(size / 3, startY, startX + (size * 2 / 3));
                    recursion(size / 3, startY + (size / 3), startX);
                    recursion(size / 3, startY + (size / 3), startX + (size / 3));
                    recursion(size / 3, startY + (size / 3), startX + (size * 2 / 3));
                    recursion(size / 3, startY + (size * 2 / 3), startX);
                    recursion(size / 3, startY + (size * 2 / 3), startX + (size / 3));
                    recursion(size / 3, startY + (size * 2 / 3), startX + (size * 2 / 3));
                    return;
                }
            }
        }

        numSize[pivot + 1]++;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        boardSize = Integer.parseInt(br.readLine());
        board = new int[boardSize][boardSize];

        for (int i = 0; i < boardSize; ++i) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < boardSize; ++j) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        recursion(boardSize, 0, 0);
        System.out.printf("%d\n%d\n%d", numSize[0], numSize[1], numSize[2]);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1780 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int boardSize;
    static int[][] board;
    static int[] numSize = { 0, 0, 0 }; // -1, 0, 1의 개수

    static void recursion(int size, int startY, int startX) {
        int pivot = board[startY][startX]; // 첫 번째 종이를 기준으로 한다.

        if (size == 1) { // 종이의 사이즈가 1 이면 그냥 값을 올려준다.
            numSize[pivot + 1]++;
            return;
        }

        for (int i = startY; i < startY + size; ++i) {
            for (int j = startX; j < startX + size; ++j) {
                if (board[i][j] != pivot) { // 종이의 숫자가 다르면 9개로 나누고 현재 함수를 닫는다.
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

        numSize[pivot + 1]++; // 모든 종이가 같으면 해당하는 값을 올려준다.
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

        recursion(boardSize, 0, 0); // 재귀 시작
        System.out.printf("%d\n%d\n%d", numSize[0], numSize[1], numSize[2]); // 결과값을 출력한다.
    }
}

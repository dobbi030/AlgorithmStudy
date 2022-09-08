import java.io.*;
import java.util.Arrays;

public class algo_1780 {
    static int N;
    static int[][] map;
    static int[] result = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //초기값 등록 및 입력
        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        findResult(map);

        //결과 출력
        for (int i : result) {
            System.out.println(i);
        }
    }

    //결과를 찾는 함수
    static void findResult(int[][] map) {
        if (allSame(map)) {
            //-1부터라서 +1 해서 결과에 저장함
            result[map[0][0] + 1] += 1;
            return;
        }
        //모두 같은 칸이 아니라면 종이를 쪼개서 각각에 대해서 연산을 다시함
        for (int[][] submap : splitMap(map)) {
            findResult(submap);
        }
    }

    //종이를 9칸으로 쪼개서 별개의 종이로 리턴
    static int[][][] splitMap(int[][] map) {
        int subLen = map.length / 3;
        int[][][] subMaps = new int[9][subLen][subLen];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                subMaps[(i / subLen) * 3 + (j / subLen)][i % subLen][j % subLen] = map[i][j];
            }
        }
        return subMaps;
    }

    //모든 칸이 같은 숫자인지 판별하는 함수
    static boolean allSame(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] != map[0][0]) {
                    return false;
                }
            }
        }
        return true;
    }
}

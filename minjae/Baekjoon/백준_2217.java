import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class algo_2217 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        //입력을 리스트에 받아줌
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine().trim()));
        }

        //내림차순 정렬
        Collections.sort(list, Collections.reverseOrder());

        int result = 0;
        int idx = 0;
        for (int num : list) {
            idx += 1;
            result = Math.max(result, num * idx);
        }

        //결과 출력
        System.out.println(result);
    }
}

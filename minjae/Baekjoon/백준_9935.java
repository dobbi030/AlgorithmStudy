import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class algo_9935 {
    static String str;
    static String boom;
    static List<Character> result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력
        str = br.readLine().trim();
        boom = br.readLine().trim();

        //결과를 담는 리스트
        result = new ArrayList<>();

        //입력된 문자열을 각각 쪼개서 반복문을 돌림
        for (char c : str.toCharArray()) {
            //결과에 담고
            result.add(c);
            //만약 boom의 마지막 문자를 발견하면
            if (c == boom.charAt(boom.length() - 1)) {
                //터지는지 확인하고
                if (define()) {
                    //터지면 터트림
                    remove();
                }
            }
        }

        //다 터지면 //비어 있으면
        if (result.isEmpty()) {
            System.out.println("FRULA");
            return;
        }

        //아니면 문자열로 합침
        String tmp = result.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println(tmp);
    }

    //뒤에서부터 삭제
    static void remove() {
        int size = result.size();
        for (int i = size - 1; i > size - 1 - boom.length(); i--) {
            result.remove(result.size() - 1);
        }
    }

    //삭제할지 말지 정하는 함수
    static boolean define() {
        if (result.size() < boom.length()) return false;
        for (int i = 0; i < boom.length(); i++) {
            if (result.get(result.size() - 1 - i) != boom.charAt(boom.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

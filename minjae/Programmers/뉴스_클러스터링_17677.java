import java.util.*;
import java.util.regex.*;

public class 뉴스_클러스터링_17677 {
    public int solution(String str1, String str2) {
        int answer = 0;

        Map<String, Integer> sub1 = splitStr(str1);
        Map<String, Integer> sub2 = splitStr(str2);

        //만약 둘다 공집합이면 결과 바로 출력
        if (sub1.isEmpty() && sub2.isEmpty()) return 65536;

        // unionMap 합집합, subMap 교집합
        Map<String, Integer> unionMap = new HashMap<>(sub2);
        Map<String, Integer> subMap = new HashMap<>();

        //미리 sub2를 넣어서 sub1과 비교
        for (String key : sub1.keySet()) {
            // 만약 중복되는 키가 있으면
            if (unionMap.containsKey(key)) {
                //합집합에 둘 중에 더 큰 값으로 갱신
                unionMap.put(key, Math.max(unionMap.get(key), sub1.get(key)));
                //교집합에는 둘 중에 더 작은 값으로 넣어줌
                subMap.put(key, Math.min(sub2.get(key), sub1.get(key)));
            } else {
                //중복되지 않았으면 바로 넣음
                unionMap.put(key, sub1.get(key));
            }
        }

        //합집합과 교집합의 value의 총합을 구해줌
        int sumUnion = unionMap.values().stream().mapToInt(e -> e).sum();
        int sumSub = subMap.values().stream().mapToInt(e -> e).sum();

        //결과 출력
        return (int) Math.floor(65536 * ((double) sumSub / (double) sumUnion));
    }

    //문자열을 쪼개주는 함수
    public Map<String, Integer> splitStr(String str) {
        Map<String, Integer> resultMap = new HashMap<>();
        //영어 문자로만 이루어진 정규식
        Pattern p = Pattern.compile("^[a-zA-Z]*$");

        for (int i = 0; i < str.length() - 1; i++) {
            String sub = str.substring(i, i + 2).toLowerCase();
            //정규식으로 비교해서 영어로만 이루어져있으면
            if (p.matcher(sub).matches()) {
                //결과 맵에 넣는데 만약 값이 이미 있으면 1을 증가시켜줌
                resultMap.merge(sub, 1, Integer::sum);
            }
        }
        return resultMap;
    }
}

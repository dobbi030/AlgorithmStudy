import java.util.*;

public class 호텔_방_배정_64063 {
    public long[] solution(long k, long[] room_number) {
        List<Long> answer = new ArrayList<>();
        boolean[] isVisit = new boolean[(int) k + 1];

        for (long each : room_number) {

            while (isVisit[(int) each]) {
                each++;
            }

            if (each > k + 1) continue;

            isVisit[(int) each] = true;
            answer.add(each);
        }

        return answer.stream().mapToLong(Long::longValue).toArray();
    }
}

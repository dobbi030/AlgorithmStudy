import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String str1, String str2) {
		int answer = 0;
		Map<String, Integer>map = new HashMap<>();
		for(int i=0, size = str1.length()-1; i<size; i++) {
			char c1 = str1.charAt(i);
			if((c1 >= 'A' && c1 <= 'Z') || (c1 >= 'a' && c1 <= 'z')) {
				char c2 = str1.charAt(i+1);
				if((c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z')) {
					String str = (String.valueOf(c1) + String.valueOf(c2)).toUpperCase();
					if(map.get(str) != null) {
						map.put(str, map.get(str)+1);
					} else {
						map.put(str, 1);
					}
				} else {
					i++;
				}
			}
		}
		Map<String, Integer>map2 = new HashMap<>();
		for(int i=0, size = str2.length()-1; i<size; i++) {
			char c1 = str2.charAt(i);
			if((c1 >= 'A' && c1 <= 'Z') || (c1 >= 'a' && c1 <= 'z')) {
				char c2 = str2.charAt(i+1);
				if((c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z')) {
					String str = (String.valueOf(c1) + String.valueOf(c2)).toUpperCase();
					if(map2.get(str) != null) {
						map2.put(str, map2.get(str)+1);
					} else {
						map2.put(str, 1);
					}
				} else {
					i++;
				}
			}
		}
		ArrayList<String> strL = new ArrayList<>();
		int minsum = 0;
		
		for(String str : map.keySet()) {
			int max = map.get(str);
			if(map2.get(str) != null) {
				int count2 = map2.get(str);
				int min = Integer.min(max, count2);
				max = Integer.max(max, count2);
				map2.remove(str);
				minsum += min;
			}
			for(int i=0; i<max; i++) {
				strL.add(str);
			}
		}
		for(String s : strL) {
			map.remove(s);			
		}
		for(String str : map2.keySet()) {
			int max = map2.get(str);
			if(map.get(str) != null) {
				int count2 = map.get(str);
				int min = Integer.min(max, count2);
				max = Integer.max(max, count2);
				minsum += min;
			}
			for(int i=0; i<max; i++) {
				strL.add(str);
			}
		}
		if(minsum == 0 && minsum == strL.size()) {
			return 65536;
		}
		answer = 65536 * minsum/strL.size();
		return answer;
    }
}

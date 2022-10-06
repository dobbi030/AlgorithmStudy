import java.util.ArrayList;

class Solution {
	public int solution(String str1, String str2) {
		if (str1.length() + str2.length() == 0)
			return 65536;

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		ArrayList<String> srr1 = new ArrayList<String>();
		ArrayList<String> srr2 = new ArrayList<String>();
		int min = 0;

		for (int i = 0; i < str1.length() - 1; i++) {
			if ((('a' <= str1.charAt(i) && str1.charAt(i) <= 'z') || ('0' <= str1.charAt(i) && str1.charAt(i) <= '9'))
					&& (('a' <= str1.charAt(i + 1) && str1.charAt(i + 1) <= 'z')
							|| ('0' <= str1.charAt(i + 1) && str1.charAt(i + 1) <= '9'))) {
				srr1.add(str1.charAt(i) + "" + str1.charAt(i + 1));
			}
		}

		for (int i = 0; i < str2.length() - 1; i++) {
			if ((('a' <= str2.charAt(i) && str2.charAt(i) <= 'z') || ('0' <= str2.charAt(i) && str2.charAt(i) <= '9'))
					&& (('a' <= str2.charAt(i + 1) && str2.charAt(i + 1) <= 'z')
							|| ('0' <= str2.charAt(i + 1) && str2.charAt(i + 1) <= '9'))) {
				srr2.add(str2.charAt(i) + "" + str2.charAt(i + 1));
			}
		}

		double s1 = srr1.size();
		double s2 = srr2.size();
		for (int i = 0; i < srr1.size(); i++) {
			if (srr2.contains(srr1.get(i))) {
				srr1.remove(i);
				srr2.remove(srr1.get(i));
				min++;
			}
		}
		System.out.println(srr1.toString());
		System.out.println(srr2.toString());

		if (srr1.size() + srr2.size() == 0)
			return 65536;

		return (int) (min / (s1 + s2 - min) * 65536);
	}
}
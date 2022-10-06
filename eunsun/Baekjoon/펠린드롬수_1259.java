import java.util.Scanner;

public class 펠린드롬수_1259 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = Integer.toString(sc.nextInt());
		StringBuilder sb = new StringBuilder();
		boolean flag = true;

		while (!s.equals(Integer.toString(0))) {
			for (int i = 0; i < s.length() / 2; i++) {
//				System.out.printf(String.format("%d번째 = %c, %d번째 = %c\n", i, s.charAt(i), s.length()-i-1, ));
				if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
					flag = false;
					break;
				}
			}

			if (flag)
				sb.append("yes\n");
			else
				sb.append("no\n");

			flag = true;
			s = sc.next();
		}

		System.out.println(sb.toString());

		sc.close();
	}
}

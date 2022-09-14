// 못 품...
import java.util.Scanner;

public class 문자열폭발_9935 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String bomb = sc.next();
		int bombCnt = bomb.length();
		boolean flag = true;

		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < bombCnt; j++) {
				if (bomb.charAt(j) != str.charAt(i + j)) {
					flag = false;
					i += j - 1;
					break;
				}
			}
			if (flag) {
				
			}
		}
	}
}

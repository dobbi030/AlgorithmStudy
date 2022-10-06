import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_1259 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();

        while (!input.equals("0")) {
            StringBuilder sb = new StringBuilder(input);
            String reverse = sb.reverse().toString();
            if (input.equals(reverse)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
            input = br.readLine().trim();
        }

    }
}

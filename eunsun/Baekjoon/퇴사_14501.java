import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Data> list;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		list = new ArrayList<>();
		visited = new boolean[N];
		ArrayList<Data> input = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			Data data = new Data();
			data.setT(sc.nextInt());
			data.setP(sc.nextInt());

			list.add(data);
		}

		perm(input, 0);
		System.out.println(max);
	}

	private static void perm(ArrayList<Data> input, int date) {
		int N = list.size();

//		System.out.println(date + "" + input.toString());

		if (date <= N) {
			int sum = 0;
			for (int i = 0; i < input.size(); i++) {
				sum += input.get(i).p;
			}
//			System.out.println(input.toString());
			max = Integer.max(sum, max);
			for (int i = date; i < N; i++) {
				if (!visited[i]) {
					visited[i] = true;
					Data temp = list.get(i);
					input.add(temp);
					perm(input, i + list.get(i).t);
					input.remove(temp);
					visited[i] = false;
				}
			}
		}
	}
}

class Data {
	int t;
	int p;

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	@Override
	public String toString() {
		return "Data [t=" + t + ", p=" + p + "]";
	}

}

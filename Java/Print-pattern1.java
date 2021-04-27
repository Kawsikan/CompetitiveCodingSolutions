package New;

import java.util.Scanner;

public class Answer {

	public static void main(String[] args) {
		// int N = Integer.parseInt(in.nextLine().trim());

		Scanner sc = new Scanner(System.in);
		System.out.println("How many time? ");
		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			for (int x = 1; x <= i; x++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = N - 1; i > 0; i--) {
			for (int x = 1; x <= i; x++) {
				System.out.print("*");
			}
			System.out.println();
		}

		sc.close();
	}

}

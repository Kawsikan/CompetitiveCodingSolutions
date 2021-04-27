import java.io.*;
import java.util.*;

public class BreakingRecords {

	// Complete the breakingRecords function below.
	static int[] breakingRecords(int[] scores) {
		int max = 0;
		int min = 0;
		for (int i = 0; i < scores.length-1; i++) {
			if (scores[i+1] > scores[i]) {
				max++;
			}
			if (scores[i+1] < scores[i]) {
				min++;
			}
		}
		int[] r = new int[2];
		r[0] = max;
		r[1] = min;
		return r;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		System.out.println("Enter the array size ");
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] scores = new int[n];

		System.out.println("Enter array ");
		String[] scoresItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int scoresItem = Integer.parseInt(scoresItems[i]);
			scores[i] = scoresItem;
		}

		int[] result = breakingRecords(scores);

		for (int i = 0; i < result.length; i++) {
			bufferedWriter.write(String.valueOf(result[i]));

			if (i != result.length - 1) {
				bufferedWriter.write(" ");
			}
		}
		bufferedWriter.newLine();
		bufferedWriter.close();
		scanner.close();
	}
}

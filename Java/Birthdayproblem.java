import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Birthday {

	// Complete the birthday function below.
	static int birthday(List<Integer> s, int d, int m) {

		int noOfWays = 0;
		int sum = 0;
		if (m <= s.size())
			for (int i = 0; i < m; i++)
				sum += s.get(i);
		if (sum == d)
			noOfWays++;

		for (int i = 0; i < s.size() - m; i++) {
			sum = sum - s.get(i) + s.get(i + m);
			if (sum == d)
				noOfWays++;
		}
		return noOfWays;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		// int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int d = Integer.parseInt(dm[0]);

		int m = Integer.parseInt(dm[1]);

		int result = birthday(s, d, m);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}

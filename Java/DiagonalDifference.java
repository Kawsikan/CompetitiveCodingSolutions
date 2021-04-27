import java.io.*;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class DiagonalDifference {

	/*
	 * Complete the 'diagonalDifference' function below. The function is expected to
	 * return an INTEGER. The function accepts 2D_INTEGER_ARRAY arr as parameter.
	 */

	public static int diagonalDifference(List<List<Integer>> arr) {

		int dif = 0;
		int temp = 0;
		int temp2 = 0;
		int n = arr.size();
		for (int i = 0; i < arr.size(); i++) {
			for (int l = 0; l < arr.get(i).size(); l++) {
				if (i == l) {
					int m = arr.get(i).get(l);
					temp = temp + m;
				}
			}
		}

		for (int i = 0; i < arr.size(); i++) {
			for (int l = arr.get(i).size(); l >= 0; l--) {
				if (i == n - l - 1) {
					int x = arr.get(i).get(l);
					temp2 = temp2 + x;
				}
			}
		}

		if (temp > temp2) {
			dif = temp - temp2;
		} else if (temp2 > temp) {
			dif = temp2 - temp;
		} else if (temp == temp2) {
			dif = 0;
		}
		return dif;

	}

}

public class No1 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> arr = new ArrayList<>();

		IntStream.range(0, n).forEach(i -> {
			try {
				arr.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
						.collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int result = DiagonalDifference.diagonalDifference(arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}

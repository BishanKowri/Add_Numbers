package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AddNumbersTest {

	@Test
	public void testSum() {
		assertEquals(0, sum(" "));
		assertEquals(10, sum("10 ")); // trims the trailing space
		assertEquals(10, sum("1 0 ")); // removes the space in between the numbers
		assertEquals(25, sum("10, 15")); // trims the space in between
		assertEquals(10, sum("1 0, ")); // ignores the blank string while trying to add
		assertEquals(10, sum("1 0, ,,")); // ignores all blank string while trying to add
		assertEquals(20, sum("1 0, ,,10")); // ignores the blank string in between while trying to add
		assertEquals(20, sum(",,,1 0, ,,1 0")); // ignores the blank string in the beginning and in between while trying
												// to add
		assertEquals(72484,
				sum("10, 15, 40,56,20,98,123,65,23,45" + ",51,6,561,56,51651,5,6515,5,51,5615,561,651,5156,156,"
						+ "165,1,6,156,65,165,,230,23,023,23,23,23,23,0,23")); // Adds all Numbers
		assertEquals(50, sum("10\n 15,25")); // trims the space in between
		assertEquals(1, sum("1,\n"));

		assertEquals(3, sum("//;\n1;2"));
		assertEquals(3, sum("//=\n1=2"));
		assertEquals(12, sum("//\t\n1\t2,3\n6,\n"));

		assertEquals(9, sum("//\t\n1\t2,-3\n6,\n"));
		assertEquals(76, sum("1\n2,-3\n6,-9,2,65\n-5\n-14\n"));
		assertEquals(20, sum("//\t\n-1\t2,-3\n6,\n,-7\t12"));
	}

	private static long sum(String numbers) {

		int sum = 0;
		String delimiter = "";
		String numArray[] = {};

		if (numbers.isBlank()) {
			return sum;
		}
		if (numbers.startsWith("//")) {
			String numArrayTemp[] = numbers.split("\n", 2);
			delimiter = numArrayTemp[0].replace("//", "");
			delimiter = "|" + delimiter;
			numbers = numArrayTemp[1];
		}
		if (delimiter.isBlank()) {
			numArray = numbers.split(",|\\n");
		} else {
			numArray = numbers.split(",|\\n" + delimiter);
		}
		for (int i = 0; i < numArray.length; i++) {
			if (numArray[i].isBlank()) {
				continue;
			}
			long num = Long.parseLong(numArray[i].replaceAll("\\s", "").trim());
			try {
				if (num < 0) {
					throw new Exception("negatives not allowed: " + num);
				} else {

					sum += num;
				}
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}

		}

		return sum;
	}
}

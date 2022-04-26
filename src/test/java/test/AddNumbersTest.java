package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import numbers.AddNumbers;

public class AddNumbersTest {

	AddNumbers an = new AddNumbers();
	
	@Test
	public void sum() {
		assertEquals(0, an.sum(" "));
		assertEquals(10, an.sum("10 ")); // trims the trailing space
		assertEquals(10, an.sum("1 0 ")); // removes the space in between the numbers
		assertEquals(25, an.sum("10, 15")); // trims the space in between
		assertEquals(10, an.sum("1 0, ")); // ignores the blank string while trying to add
		assertEquals(10, an.sum("1 0, ,,")); // ignores all blank string while trying to add
		assertEquals(20, an.sum("1 0, ,,10")); // ignores the blank string in between while trying to add
		assertEquals(20, an.sum(",,,1 0, ,,1 0")); // ignores the blank string in the beginning and in between while trying
												// to add
		assertEquals(72484,
				an.sum("10, 15, 40,56,20,98,123,65,23,45" + ",51,6,561,56,51651,5,6515,5,51,5615,561,651,5156,156,"
						+ "165,1,6,156,65,165,,230,23,023,23,23,23,23,0,23")); // Adds all Numbers
		assertEquals(50, an.sum("10\n 15,25")); // trims the space in between
		assertEquals(1, an.sum("1,\n"));

		assertEquals(3, an.sum("//;\n1;2")); // Adding new delimiter
		assertEquals(3, an.sum("//=\n1=2")); // Adding new delimiter
		assertEquals(12, an.sum("//\t\n1\t2,3\n6,\n")); // Adding new delimiter with existing delimiters

		assertEquals(9, an.sum("//\t\n1\t2,-3\n6,\n")); // Adding negative number
		assertEquals(76, an.sum("1\n2,-3\n6,-9,2,65\n-5\n-14\n")); // Adding multiple negative numbers
		assertEquals(20, an.sum("//\t\n-1\t2,-3\n6,\n,-7\t12")); // Adding multiple negative numbers with new delimiter and existing delimiters
	}

	
}

package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AddNumbersTest {
	
	@Test
	 public void testSum() {  
		assertEquals(0,sum(" ")); 
		assertEquals(10,sum("10 ")); //trims the trailing space 
		assertEquals(10,sum("1 0 ")); //removes the space in between the numbers
		assertEquals(10,sum("1 0, ")); //ignores the blank string while trying to add 
		assertEquals(10,sum("1 0, ,,")); //ignores all blank string while trying to add 
		assertEquals(20,sum("1 0, ,,10")); //ignores the blank string in between while trying to add 
		assertEquals(20,sum(",,,1 0, ,,1 0")); //ignores the blank string in the beginning and in between while trying to add 
        assertEquals(25,sum("10, 15")); //trims the leading space 
        assertEquals(72484,sum("10, 15, 40,56,20,98,123,65,23,45"
        		+ ",51,6,561,56,51651,5,6515,5,51,5615,561,651,5156,156,"
        		+ "165,1,6,156,65,165,,230,23,023,23,23,23,23,0,23")); //Adds all Numbers
        
    }

	private static long sum(String numbers) {
		int sum = 0;
		if (numbers.isBlank()) {
			return sum;
		}
		String numArray[] = numbers.split(",");
		for (int i=0;i<numArray.length;i++) {
			if (numArray[i].isBlank()) {
				continue;
			}
			long num = Long.parseLong(numArray[i].replaceAll("\\s", "").trim());
			sum += num;
		}
		return sum;
	}  
}

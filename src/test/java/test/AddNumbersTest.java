package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AddNumbersTest {
	
	@Test
	 public void testSum() {  
        assertEquals(25,sum("10, 15"));  
    }

	private static long sum(String numbers) {
		int sum = 0;
		String numArray[] = numbers.split(",");
		
		for (int i=0;i<numArray.length;i++) {
			int num = Integer.parseInt(numArray[i].trim());
			sum += num;
		}
		return sum;
	}  
}

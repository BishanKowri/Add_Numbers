package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AddNumbersTest {
	
	@Test
	 public void testSum() {  
        assertEquals(25,sum(10, 15));  
    }

	private static long sum(int i, int j) {
		return i+j;
	}  
}

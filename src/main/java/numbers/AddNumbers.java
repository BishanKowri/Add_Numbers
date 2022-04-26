package numbers;

public class AddNumbers {
	
	public long sum(String numbers) {

		int sum = 0;
		String delimiter = "";
		String numArray[] = {};
		
		// Check if the number is empty or just with spaces
		if (numbers.isBlank()) {
			return sum;
		}
		// Check if there is any delimiter present at the beggining
		if (numbers.startsWith("//")) {
			String numArrayTemp[] = numbers.split("\n", 2);
			delimiter = numArrayTemp[0].replace("//", "");
			delimiter = "|" + delimiter;
			numbers = numArrayTemp[1];
		}
		
		numArray = numbers.split(",|\\n" + delimiter);
		
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

	public static void main(String[] args) {
		
		AddNumbers an = new AddNumbers();
		
		System.out.println(an.sum("10 "));
		System.out.println(an.sum("10, 15"));
		System.out.println(an.sum(",,,1 0, ,,1 0"));
		System.out.println(an.sum("10, 15, 40,56,20,98,123,65,23,45" + ",51,6,561,56,51651,5,6515,5,51,5615,561,651,5156,156,"
				+ "165,1,6,156,65,165,,230,23,023,23,23,23,23,0,23"));
		System.out.println(an.sum("//;\n1;2"));
		System.out.println(an.sum("//\t\n1\t2,-3\n6,\n"));

	}

}

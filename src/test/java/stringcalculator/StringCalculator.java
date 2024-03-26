package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public static int calculate(String input) {

		if (input == null || input.isEmpty()) {
			return 0;
		}

		int result = 0;

		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
		if (m.find()) {
			String customDelimiter = m.group(1);
			String[] numbers = m.group(2).split(customDelimiter);
			for (String number : numbers) {
				int value = Integer.parseInt(number);
				if (value < 0) {
					throw new RuntimeException();
				}
				result += value;
			}
			return result;
		}

		String[] numbers = input.split("[,;]");
		for (String number : numbers) {
			int value = Integer.parseInt(number);
			if (value < 0) {
				throw new RuntimeException();
			}
			result += value;
		}
		return result;
	}
}

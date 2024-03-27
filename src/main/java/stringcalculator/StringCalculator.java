package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMETER = "[,;]";
    private static final int DEFAULT_RETURN_VALUE = 0;

    public static int calculate(String input) {
        if (isNullOrBlank(input)) {
            return DEFAULT_RETURN_VALUE;
        }

        Matcher m = PATTERN.matcher(input);
        if (m.find()) {
            return add(split(m.group(1), m.group(2)));
        }

        return add(split(DEFAULT_DELIMETER, input));
    }

    private static boolean isNullOrBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] split(String delimiter, String text) {
        return text.split(delimiter);
    }

    private static int add(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += parsePositiveInteger(number);
        }
        return result;
    }

    private static int parsePositiveInteger(String number) {
        int value = Integer.parseInt(number);
        if (value < 0) {
            throw new RuntimeException();
        }
        return value;
    }
}

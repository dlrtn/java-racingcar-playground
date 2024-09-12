import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final ArrayList<String> delimiters = new ArrayList<>(Arrays.asList(",", ":"));

    public static int splitAndSum(String string) {
        if (isValidString(string)) {
            return 0;
        }

        if (checkCustomDelimiter(string)) {
            string = registerCustomDelimiter(string);
        }

        String[] strings = split(string);

        int[] numbers = convertToIntArray(strings);

        for (int number : numbers) {
            if (number < 0) {
                throw new RuntimeException();
            }
        }

        return sum(numbers);
    }

    private static boolean isValidString(String string) {
        return string == null || string.isEmpty();
    }

    private static boolean checkCustomDelimiter(String string) {
        return string.startsWith("//");
    }

    private static String registerCustomDelimiter(String string) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(string);

        if (m.find()) {
            String customDelimiter = m.group(1);
            delimiters.add(customDelimiter);

            return m.group(2);
        }

        return string;
    }

    private static String[] split(String string) {
        return string.split(getDelimiter());
    }

    private static String getDelimiter() {
        return String.join("|", delimiters);
    }

    private static int[] convertToIntArray(String[] strings) {
        return Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

}

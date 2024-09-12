import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String string) {
        if (isValidString(string)) {
            return 0;
        }

        String[] strings = split(string);

        int[] numbers = convertToIntArray(strings);

        return sum(numbers);
    }

    private static boolean isValidString(String string) {
        return string == null || string.isEmpty();
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    private static String[] split(String string) {
        return string.split(getDelimiter());
    }

    private static int[] convertToIntArray(String[] strings) {
        return Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static String getDelimiter() {
        return "[,|:]";
    }

}

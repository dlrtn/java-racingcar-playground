import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String string) {
        if (isValidString(string)) {
            return 0;
        }

        int[] numbers = splitAndConvertToIntArray(string);

        return sum(numbers);
    }

    private static int sum(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    private static int[] splitAndConvertToIntArray(String string) {
        return Arrays.stream(string.split("[,:]"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static boolean isValidString(String string) {
        return string == null || string.isEmpty();
    }

}

public class StringAddCalculator {

    public static int splitAndSum(String string) {
        if (string == null || string.isEmpty()) {
            return 0;
        }

        int sum = 0;

        sum += Integer.parseInt(string);

        return sum;
    }

}

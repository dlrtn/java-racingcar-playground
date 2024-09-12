public class StringAddCalculator {

    public static int splitAndSum(String string) {
        if (string == null || string.isEmpty()) {
            return 0;
        }

        int sum = 0;

        String[] strings = string.split(",");

        for (String s : strings) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }

}

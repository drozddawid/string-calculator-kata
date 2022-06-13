import java.util.Arrays;

public class StringCalculator {
    public static int add(String numbers) throws IllegalArgumentException {
        String delimiterRegEx = " *, *| *\n *";
        boolean useCustomDelimiter = false;
        int delimiterEndIndex = numbers.indexOf('\n');
        try {
            if (numbers.startsWith("//")) {
                String additionalDelimiter = numbers.substring(2, delimiterEndIndex).strip();
                useCustomDelimiter = true;
                if (additionalDelimiter.length() == 1)
                    delimiterRegEx += "| *" + additionalDelimiter + " *";
                else
                    throw new IllegalArgumentException("Expected delimiter to be one character length, got \"" + additionalDelimiter + "\"");
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Error when parsing additional delimiter. Is there any?");
        }
        if (useCustomDelimiter)
            numbers = (delimiterEndIndex == numbers.length() - 1 ? "" : numbers.substring(delimiterEndIndex + 1));

        if (numbers.length() == 0) return 0;

        String[] split = numbers.split(delimiterRegEx);
        try {
            if (split.length > 1) {
                return Arrays.stream(split).mapToInt(Integer::parseInt).sum();
            } else {
                return Integer.parseInt(split[0]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Arguments parsing error. Given arguments: " + numbers + ". Exception thrown while parsing: NumberFormatException" + e.getMessage());
        }
    }
}

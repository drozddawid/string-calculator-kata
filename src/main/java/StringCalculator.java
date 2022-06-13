import java.util.Arrays;

public class StringCalculator {
    public static int add(String numbers){
        if(numbers.length() == 0) return 0;
        String[] split = numbers.split(" *, *| *\n *");
        try {
            if (split.length > 1) {
                return Arrays.stream(split).mapToInt(Integer::parseInt).sum();
            } else {
                return Integer.parseInt(split[0]);
            }
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("Arguments parsing error. Given arguments: " + numbers + ". Exception thrown while parsing: NumberFormatException" + e.getMessage());
        }
    }
}

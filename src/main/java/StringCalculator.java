public class StringCalculator {
    public static int add(String numbers){
        if(numbers.length() == 0) return 0;
        String[] split = numbers.split(" *, *");
        try {
            if (split.length > 1) {
                return Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
            } else {
                return Integer.parseInt(split[0]);
            }
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("Arguments parsing error. Given arguments: " + numbers + ". Exception thrown while parsing: NumberFormatException" + e.getMessage());
        }
    }
}

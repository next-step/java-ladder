package ladder.util;

public class NumberUtil {
    private NumberUtil(){ }
    public static int convertStringToInt(String numberString) {
        int number = Integer.parseInt(numberString.trim());
        return number;
    }
}

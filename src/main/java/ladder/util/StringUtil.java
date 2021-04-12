package ladder.util;

public class StringUtil {

    public static String[] split(String inputString, String delimiter) {
        if (isIllegalArgument(inputString)) {
            throw new IllegalArgumentException();
        }
        return inputString.split(delimiter);
    }

    private static boolean isIllegalArgument(String inputString) {
        return inputString == null || "".equals(inputString);
    }
}

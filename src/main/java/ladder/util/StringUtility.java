package ladder.util;

public class StringUtility {

    private StringUtility() {
    }

    public static boolean isBlank(String inputData) {
        return inputData == null || inputData.trim().length() == 0;
    }
}

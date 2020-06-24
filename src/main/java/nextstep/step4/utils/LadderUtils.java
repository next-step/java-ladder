package nextstep.step4.utils;

import java.util.Arrays;
import java.util.List;

public class LadderUtils {
    private static final String DELIMITER = ",";

    public static List<String> splitString(String inputStr) {
        return Arrays.asList(inputStr.split(DELIMITER));
    }

    public static boolean isBlank(String result) {
        return result == null || result.replace(" ", "").length() == 0;
    }
}

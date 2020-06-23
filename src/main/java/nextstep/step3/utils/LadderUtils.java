package nextstep.step3.utils;

import nextstep.step3.domain.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderUtils {
    private static final String DELIMITER = ",";

    public static List<String> splitString(String inputStr) {
        return Arrays.asList(inputStr.split(DELIMITER));
    }

    public static boolean isBlank(String result) {
        return result == null || result.replace(" ", "").length() == 0;
    }
}

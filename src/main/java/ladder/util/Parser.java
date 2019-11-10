package ladder.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Parser {
    private static final String DELIMITER = ",";

    public static List<String> convertToList(String inputValue) {
        if (StringUtils.isEmpty(inputValue)) {
            return Collections.emptyList();
        }

        String[] splitValue = splitFrom(inputValue);
        return Arrays.asList(splitValue);
    }

    private static String[] splitFrom(String inputValue) {
        return inputValue.split(DELIMITER);
    }
}

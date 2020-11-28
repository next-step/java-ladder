package common;

import java.util.Collections;

import static common.CommonConstants.JOIN_DELIMITER_EMPTY;

public class StringUtils {
    public static String padByBlank(String inputString, int numberOfPadding) {
        return String.format("%1$" + numberOfPadding + "s", inputString);
    }

    public static String copyAndJoin(int numberOfTemplateBlank, String delimiter) {
        return String.join(JOIN_DELIMITER_EMPTY, Collections.nCopies(numberOfTemplateBlank, delimiter));
    }
}

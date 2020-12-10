package common;

import java.util.Collections;

import static common.DelimiterConstants.JOIN_DELIMITER;

public class StringUtils {
    public static final String BLANK = " ";
    private static final int NUMBER_OF_NAME_PADDING = 5;

    private StringUtils(){}

    public static void padAndPrint(final String s) {
        System.out.print(StringUtils.padByBlank(s, NUMBER_OF_NAME_PADDING).concat(BLANK));
    }

    public static String padByBlank(String inputString, int numberOfPadding) {
        return String.format("%1$" + numberOfPadding + "s", inputString);
    }

    public static String copyAndJoin(int numberOfTemplateBlank, String delimiter) {
        return String.join(JOIN_DELIMITER, Collections.nCopies(numberOfTemplateBlank, delimiter));
    }
}

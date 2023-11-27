package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String DELIMETER = ",";
    private static final String EMPTYSPACE = " ";

    private Parser() {
    }

    public static List<String> splitString(String value) {
        String[] strings = removeEmptyspace(value).split(DELIMETER);
        return new ArrayList<>(Arrays.asList(strings));
    }

    private static String removeEmptyspace(String value) {
        return value.replaceAll(EMPTYSPACE, "");
    }

    public static int numberFormatParsing(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}

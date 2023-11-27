package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parsor {
    private static final String DELIMETER = ",";
    private static final String EMPTYSPACE = " ";

    private Parsor() {
    }

    public static List<String> splitString(String value) {
        String[] strings = removeEmptyspace(value).split(DELIMETER);
        return new ArrayList<>(Arrays.asList(strings));
    }

    private static String removeEmptyspace(String value) {
        return value.replaceAll(EMPTYSPACE, "");
    }
}

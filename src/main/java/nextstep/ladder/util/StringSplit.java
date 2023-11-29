package nextstep.ladder.util;

import java.util.List;

public class StringSplit {

    private static final String DELIMITER = ",";

    public static String[] stringSplitToList(String value) {
        return value.split(DELIMITER);
    }
}

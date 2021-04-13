package nextstep.ladder.util;

import java.util.Arrays;

public class StringUtil {

    static final String SPLIT_SYMBOL = ",";

    private StringUtil(){}

    public static String[] splitCommaByString(String inputString){
        return Arrays.stream(inputString.split(SPLIT_SYMBOL))
                    .map(String::trim)
                    .toArray(String[]::new);
    }
}

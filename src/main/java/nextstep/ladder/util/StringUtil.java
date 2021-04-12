package nextstep.ladder.util;

import java.util.Arrays;

public class StringUtil {
    private StringUtil(){}

    public static String[] splitCommaByString(String inputString){
        return Arrays.stream(inputString.split(","))
                    .map(String::trim)
                    .toArray(String[]::new);
    }
}

package nextstep.ladder.util;

import nextstep.ladder.common.Constants;

import java.util.Arrays;

public class StringUtil {

    private StringUtil(){}

    public static String[] splitCommaByString(String inputString){
        return Arrays.stream(inputString.split(Constants.SPLIT_SYMBOL))
                    .map(String::trim)
                    .toArray(String[]::new);
    }
}

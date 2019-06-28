package nextstep.ladder.util;

import java.util.Arrays;
import java.util.List;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-29 03:08
 */
public class StringUtil {

    private static final String SPLIT_FORMAT_COMMA = ",";

    public static List<String> split(String split) {
        return Arrays.asList(split.split(SPLIT_FORMAT_COMMA));
    }
}

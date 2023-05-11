package ladder.util;

import ladder.common.Constants;

public class ViewUtil {
    public static String adjustGap(String input){
        return concatInput(setPrefix(6-input.length()),input);
    }

    public static String concatInput(String prefix, String input) {
        return prefix.concat(input);
    }

    public static String setPrefix(int limit) {
        return Constants.SPACE_BAR.repeat(limit);
    }
}

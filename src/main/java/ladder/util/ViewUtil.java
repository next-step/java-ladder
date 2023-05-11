package ladder.util;

import ladder.common.Constants;

public class ViewUtil {
    public static String adjustGap(String input){
        return concatInput(setPrefix(input.length()),input);
    }

    private static String concatInput(String prefix, String input) {
        return prefix.concat(input);
    }

    private static String setPrefix(int size) {
        return Constants.SPACE_BAR.repeat(6 - size);
    }
}

package ladder.util;

public class ViewUtil {
    public static final String SPACE_BAR = " ";
    private ViewUtil() {
    }

    public static String adjustGap(String input){
        return concatInput(setPrefix(6-input.length()),input);
    }

    public static String concatInput(String prefix, String input) {
        return prefix.concat(input);
    }

    public static String setPrefix(int limit) {
        return SPACE_BAR.repeat(limit);
    }
}

package step3_renewal.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtil {

    private StringUtil() {
    }

    public static boolean isEmpty(String value) {
        return null == value || value.trim().isEmpty();
    }

    public static String padRight(String value, int repeat) {
        return String.format("%-" + repeat + "s", value);
    }

    public static String padLeft(int repeat, String value){
        return String.format("%" + repeat + "s", value);
    }
    private static final String NAME_SEPARATOR = ",";

    public static List<String> splitNames(String name) {
        return new ArrayList<>(Arrays.asList(splitName(name)));
    }

    private static String[] splitName(String name) {
        return name.split(NAME_SEPARATOR);
    }
}

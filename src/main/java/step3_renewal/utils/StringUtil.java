package step3_renewal.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtil {
    private static final String NAME_SEPARATOR = ",";

    private StringUtil() {
    }

    public static boolean isEmpty(String value) {
        return null == value || value.trim().isEmpty();
    }

    public static String padLeft(int repeat, String value) {
        return String.format("%" + repeat + "s", value);
    }

    public static List<String> splitToList(String name) {
        return new ArrayList<>(Arrays.asList(split(name)));
    }

    private static String[] split(String name) {
        return name.split(NAME_SEPARATOR);
    }
}

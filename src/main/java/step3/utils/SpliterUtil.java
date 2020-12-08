package step3.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpliterUtil {
    private static final String NAME_SEPARATOR = ",";

    public static List<String> splitNames(String name) {
        return new ArrayList<>(Arrays.asList(splitName(name)));
    }

    private static String[] splitName(String name) {
        return name.split(NAME_SEPARATOR);
    }
}

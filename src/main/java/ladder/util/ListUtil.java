package ladder.util;

import java.util.List;

public class ListUtil {
    private ListUtil() {}

    public static List<String> listOfString(String[] stringArray) {
        return List.of(stringArray);
    }
}

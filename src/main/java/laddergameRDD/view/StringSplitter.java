package laddergameRDD.view;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    public static List<String> splitString(String targetString) {
        return Arrays.asList(targetString.split(","));
    }
}

package step2.domain;

import java.util.Arrays;
import java.util.List;

public class Result {
    private static final String delimiter = ",";
    private final List<String> strings;

    public Result(String string) {
        strings = Arrays.asList(string.split(delimiter));
    }

    public List<String> getStrings() {
        return strings;
    }
}
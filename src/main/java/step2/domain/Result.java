package step2.domain;

import java.util.Arrays;
import java.util.List;

public class Result {
    private static final String DELIMITER = ",";
    private final List<String> strings;

    public Result(String string) {
        strings = Arrays.asList(string.split(DELIMITER));
    }

    public List<String> getStrings() {
        return strings;
    }
}
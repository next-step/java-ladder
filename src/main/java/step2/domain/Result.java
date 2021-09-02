package step2.domain;

import java.util.Arrays;
import java.util.List;

public class Result {
    private static final String DELIMITER = ",";
    private final List<String> items;

    public Result(String string) {
        items = Arrays.asList(string.split(DELIMITER));
    }

    public List<String> getItems() {
        return items;
    }
}
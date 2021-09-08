package step2.domain;

import java.util.Arrays;
import java.util.List;

public class Results {
    private static final String DELIMITER = ",";
    private final List<String> items;

    public Results(String string) {
        items = Arrays.asList(string.split(DELIMITER));
    }

    public List<String> getItems() {
        return items;
    }

    public String resultOfPosition(int position) {
        return items.get(position);
    }
}
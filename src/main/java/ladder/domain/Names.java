package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Names {
    private final List<String> names;

    public Names(String text) {
        this.names = Arrays.asList(text.split(","));
        validateNameMaxLength(names);
    }

    private void validateNameMaxLength(List<String> names) {
        if (names.stream().anyMatch(name -> name.length() > 5))
            throw new IllegalArgumentException("The name should be up to 5 letters.");
    }

    public List<String> getAll() {
        return Collections.unmodifiableList(names);
    }

    public int connectSize() {
        return names.size() - 1;
    }
}

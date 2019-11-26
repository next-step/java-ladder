package reladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Names {

    private static final String DELIMITER = ",";

    private Set<String> names;

    public Names(String names) {
        this.names = makeNames(names);
    }

    private Set<String> makeNames(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .collect(Collectors.toSet());
    }

    String getName(int index) {
        return new ArrayList<>(names)
                .get(index);
    }

    public int length() {
        return this.names.size();
    }
}

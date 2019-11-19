package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private static final String DELIMITER = ",";
    private List<String> names;

    Names(String names) {
        this.names = makeNames(names);
    }

    private List<String> makeNames(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .collect(Collectors.toList());
    }

    String getName(int index) {
        return this.names.get(index);
    }

    int length() {
        return this.names.size();
    }

    public List<String> getNames() {
        return new ArrayList<>(names);
    }
}

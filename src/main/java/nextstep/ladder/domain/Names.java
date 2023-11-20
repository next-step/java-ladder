package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Names {

    private static final String NAMES_DELIMITER = ",";
    private final List<Name> names = new ArrayList<>();

    public Names(String names) {
        Arrays.stream(names.split(NAMES_DELIMITER))
                .forEach(name -> this.names.add(new Name(name)));
    }

    public List<Name> names() {
        return Collections.unmodifiableList(names);
    }

    public int size() {
        return names.size();
    }
}

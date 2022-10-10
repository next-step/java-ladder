package nextstep.ladder.domain.player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Names {
    public static final String DEFAULT_DELIMITER = ",";

    private final List<Name> values;

    public static Names of(String names) {
        return new Names(names);
    }

    public Names(String names) {
        values = Stream.of(names.split(DEFAULT_DELIMITER))
                .map(Name::of)
                .collect(Collectors.toList());
    }

    public boolean contains(Name name) {
        return values.contains(name);
    }

    public int size() {
        return values.size();
    }

    public List<Name> values() {
        return Collections.unmodifiableList(values);
    }
}

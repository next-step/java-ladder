package nextstep.ladder.domain.player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Names {
    private final List<Name> values;

    public Names(String names, String delimiter) {
        values = Stream.of(names.split(delimiter))
                .map(Name::new)
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

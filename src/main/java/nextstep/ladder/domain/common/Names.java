package nextstep.ladder.domain.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private final List<Name> names;

    private Names(final List<Name> names) {
        this.names = names;
    }

    public static Names of(final List<Name> names) {
        return new Names(names);
    }

    public static Names of(final String names) {
        return new Names(Arrays.stream(names.split(","))
            .map(Name::of)
            .collect(Collectors.toList()));
    }

    public int size() {
        return names.size();
    }

    public int indexOf(final Name name) {
        return names.indexOf(name);
    }

    public boolean contains(final Name name) {
        return names.contains(name);
    }

    public List<Name> getValues() {
        return Collections.unmodifiableList(names);
    }
}

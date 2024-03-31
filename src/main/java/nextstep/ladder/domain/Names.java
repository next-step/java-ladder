package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private final List<Name> names;

    public Names(final String[] names) {
        this.names = Arrays.stream(names)
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public int findStartRow(final Name name) {
        return names.indexOf(name);
    }

    public int getNumberOfNames() {
        return names.size();
    }

    public List<Name> getNames() {
        return names;
    }
}

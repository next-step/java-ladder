package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class PersonNames {

    private final List<Name> names;

    public PersonNames() {
        this(new ArrayList<>());
    }

    public PersonNames(String[] names) {
        this(Arrays.stream(names)
            .map(Name::new)
            .collect(Collectors.toList())
        );
    }

    public PersonNames(List<Name> names) {
        this.names = names;
    }

    public int size() {
        return names.size();
    }

    @Override
    public String toString() {
        return names.stream()
            .map(Name::toString)
            .collect(Collectors.joining());
    }
}

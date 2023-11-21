package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private final List<Name> names;

    public Names(List<String> names) {
        this.names = names.stream()
            .map(Name::new)
            .collect(Collectors.toList());
    }

    public int size() {
        return this.names.size();
    }

    public List<Name> names() {
        return Collections.unmodifiableList(this.names);
    }

    public Name name(int index) {
        return this.names.get(index);
    }

}

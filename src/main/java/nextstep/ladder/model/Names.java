package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Names {
    private final List<Name> names;

    public Names(List<String> names) {
        this.names = names.stream().map(Name::new).collect(Collectors.toList());
    }

    public int size() {
        return names.size();
    }

    public Name get(int index) {
        return names.get(index);
    }

    public Stream<Name> stream() {
        return names.stream();
    }
}

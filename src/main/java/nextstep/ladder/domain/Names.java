package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;

public class Names {
    private final List<Name> names;

    public Names(String input) {
        this(Arrays.stream(input.split(",")).map(n -> new Name(n)).toList());
    }

    public Names(List<Name> names) {
        this.names = List.copyOf(names);
    }

    public List<Name> getValues() {
        return names;
    }

    public int size() {
        return names.size();
    }

}

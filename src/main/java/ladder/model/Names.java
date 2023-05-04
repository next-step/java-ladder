package ladder.model;

import java.util.List;

public class Names {
    private final List<Name> names;

    public Names(List<Name> names) {
        this.names = names;
    }

    public Names(Name... names) {
        this.names = List.of(names);
    }

    public int size() {
        return names.size();
    }

}

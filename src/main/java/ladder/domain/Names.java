package ladder.domain;

import java.util.List;

public class Names {
    private final List<Name> names;

    public Names(List<Name> names) {
        this.names = names;
    }

    public List<Name> names() {
        return names;
    }

    public int size() {
        return names.size();
    }
}

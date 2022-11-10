package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Names {
    private final List<Name> names = new ArrayList<>();

    private Names(List<String> names) {
        for (String name : names) {
            this.names.add(Name.of(name));
        }
    }

    public static Names of(List<String> names) {
        return new Names(names);
    }

    public int getNamesSize() {
        return names.size();
    }

    public List<Name> getNames() {
        return names;
    }
}

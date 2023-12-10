package nextstep.ladder.domain;

import java.util.List;

public class Names {
    private List<Name> names;

    public Names(List<Name> names) {
        this.names = names;
    }

    public int size() {
        return names.size();
    }

    public int getFirstNameLength() {
        return names.stream()
                .findFirst()
                .map(name -> name.getName().length())
                .orElse(0);
    }

    public List<Name> getNames() {
        return names;
    }
}

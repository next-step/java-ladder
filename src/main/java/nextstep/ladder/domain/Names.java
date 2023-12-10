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
}

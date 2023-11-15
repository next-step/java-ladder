package nextstep.ladder.domain;

import java.util.List;

public class Names {

    private final List<Name> names;

    public Names(List<Name> names) {
        this.names = List.copyOf(names);
    }
}

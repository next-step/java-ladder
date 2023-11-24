package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Participants {
    private final List<Name> names;

    public Participants(List<Name> names) {
        this.names = new ArrayList<>(names);
    }

    public List<Name> names() {
        return Collections.unmodifiableList(names);
    }
}

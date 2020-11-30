package ladder.domain;

import java.util.List;

public class Participants {

    private List<Name> names;

    private Participants(List<Name> names) {
        this.names = names;
    }

    public static Participants of(List<Name> names) {
        return new Participants(names);
    }

    public List<Name> getNames() {
        return this.names;
    }

}

package step2.domain.ladder;

import java.util.List;

public class Participants {
    private final List<String> names;

    private Participants(List<String> names) {
        this.names = names;
    }

    public static Participants of(List<String> names) {
        return new Participants(names);
    }

    public List<String> inline() {
        return names;
    }
}

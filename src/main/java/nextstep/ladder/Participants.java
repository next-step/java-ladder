package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Name> names;

    public Participants(List<String> names) {
        this.names = names.stream()
                .map(Name::of)
                .collect(Collectors.toList());
    }
}

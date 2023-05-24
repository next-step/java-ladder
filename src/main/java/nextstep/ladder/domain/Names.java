package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private final List<Name> names;

    public Names(List<Name> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names.stream()
                .map(Name::getName)
                .collect(Collectors.toList());
    }
}

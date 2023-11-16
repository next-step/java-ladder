package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private final List<Name> names;

    public Names(List<String> names) {
        this.names = names.stream()
            .map(Name::new)
            .collect(Collectors.toList());
    }

}

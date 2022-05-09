package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private List<Name> names;

    public Names(List<String> names) {
        this.names = names.stream()
            .map(Name::new)
            .collect(Collectors.toUnmodifiableList());
    }

    public List<String> get() {
        return names.stream()
            .map(Name::get)
            .collect(Collectors.toUnmodifiableList());
    }

}

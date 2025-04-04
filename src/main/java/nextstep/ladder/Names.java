package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private final List<Name> names;

    private Names(List<Name> names) {
        this.names = names;
    }

    public static Names of(String names) {
        return new Names(
                Arrays.stream(names.split(","))
                        .map(Name::of)
                        .collect(Collectors.toList())
        );
    }

    public List<Name> getListNames() {
        return names;
    }
}

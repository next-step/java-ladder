package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private final List<Name> names;

    private Names(List<Name> names) {
        this.names = names;
    }

    public static Names of(List<Name> names) {
        return new Names(names);
    }

    public List<Name> getListNames() {
        return names;
    }
}

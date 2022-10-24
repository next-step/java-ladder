package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    public static final String NAME_REGEX = ",";
    private final List<Name> names;

    public Names(String names) {
        this(Arrays.stream(names.split(NAME_REGEX))
                .map(name -> new Name(name))
                .collect(Collectors.toList()));
    }

    public Names(List<Name> names) {
        this.names = names;
    }

    public List<Name> getNames() {
        return names;
    }
}

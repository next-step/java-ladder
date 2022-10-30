package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Names {

    public static final String NAME_REGEX = ",";

    private final List<Name> names;

    public Names(List<Name> names) {
        this.names = names;
    }

    public static Names of(String candidates) {
        List<Name> names = Arrays.stream(candidates.split(NAME_REGEX))
                .map(name -> new Name(name))
                .collect(Collectors.toList());
        return new Names(names);
    }

    public List<Name> getNames() {
        return names;
    }

    public int getCountOfNames() {
        return names.size();
    }

}

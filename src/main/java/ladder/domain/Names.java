package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Names {

    private final List<Name> names;

    public Names(List<Name> names) {
        this.names = names;
    }

    public static Names of(String[] candidates) {
        return Stream.of(candidates)
                .map(Name::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Names::new));
    }

    public List<Name> getNames() {
        return names;
    }

    public int getCountOfNames() {
        return names.size();
    }

}

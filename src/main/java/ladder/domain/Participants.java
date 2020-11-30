package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private List<Name> names;

    private Participants(List<Name> names) {
        this.names = names;
    }

    public static Participants of(String names) {
        return new Participants(create(names));
    }

    private static List<Name> create(String name) {
        String[] names = name.split(",");
        return Arrays
                .stream(names)
                .map(Name::of)
                .collect(Collectors.toList());
    }

    public List<Name> getNames() {
        return this.names;
    }

}

package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private static final String NAME_SEPARATOR = ",";
    private static final Integer MIN_LENGTH = 2;

    private final List<Name> names;

    private Participants(List<Name> names) {
        this.names = names;
    }

    public static Participants of(String names) {
        validate(names);
        return new Participants(create(names));
    }

    private static List<Name> create(String name) {
        String[] names = name.split(NAME_SEPARATOR);
        return Arrays
                .stream(names)
                .map(Name::of)
                .collect(Collectors.toList());
    }

    public List<Name> getNames() {
        return this.names;
    }

    private static void validate(String name) {
        countOfPerson(name);
    }

    private static void countOfPerson(String name) {
        String[] names = name.split(NAME_SEPARATOR);
        if (names.length < MIN_LENGTH) {
            throw new IllegalArgumentException("참여하는 사람은 최소 2명입니다.");
        }
    }
}

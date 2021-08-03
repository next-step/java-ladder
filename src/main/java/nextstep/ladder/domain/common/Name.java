package nextstep.ladder.domain.common;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.common.exception.InvalidNameException;

public class Name {

    private static final int NAME_LENGTH_MAX = 5;

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name of(String name) {
        createValidation(name);
        return new Name(name);
    }

    public static List<Name> of(List<String> names) {
        return names.stream()
            .map(Name::of)
            .collect(Collectors.toList());
    }

    private static void createValidation(String name) {
        if (name.length() > NAME_LENGTH_MAX) {
            throw new InvalidNameException();
        }
    }

    public String getName() {
        return name;
    }
}

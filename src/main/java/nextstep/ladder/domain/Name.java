package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableList;

public class Name {

    protected static final String ILLEGAL_LENGTH_ERROR_MESSAGE = "이름의 길이는 1이상 5이하만 가능합니다.";
    protected static final int MIN_LENGTH = 1;
    protected static final int MAX_LENGTH = 5;

    private final String name;

    public static List<Name> listOf(List<String> names) {
        return unmodifiableList(
                names.stream()
                        .map(Name::new)
                        .collect(Collectors.toList())
        );
    }

    public Name(String name) {
        checkLength(name);
        this.name = name;
    }

    private void checkLength(String name) {
        if (name == null || name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ILLEGAL_LENGTH_ERROR_MESSAGE);
        }
    }

}

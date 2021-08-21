package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import ladder.exception.PersonCountException;

public class Names {
    private static final String PERSON_NUMBER_MIN_EXCEPTION_COMMENT = "사람이름을 적어도 %d명 이상 입력해야 합니다.";
    private static final String NAMES_IS_NULL_EXCEPTION_COMMENT = "Names가 널값 입니다.";
    private static final int PERSON_NUMBER_MIN = 2;

    final List<Name> names;

    private Names(List<Name> names) {
        validate(names);
        this.names = names;
    }

    public static Names from(List<Name> names) {
        return new Names(names);
    }

    public static Names from(String names) {
        return from(Arrays.stream(names.split(","))
            .map(name -> Name.from(name.trim()))
            .collect(Collectors.toList()));
    }

    private void validate(List<Name> names) {
        if (Objects.isNull(names)) {
            throw new NullPointerException(NAMES_IS_NULL_EXCEPTION_COMMENT);
        }

        if (names.size() < PERSON_NUMBER_MIN) {
            throw new PersonCountException(String.format(PERSON_NUMBER_MIN_EXCEPTION_COMMENT, PERSON_NUMBER_MIN));
        }
    }

    public List<String> toStringList() {
        return names.stream()
            .map(Name::name)
            .collect(Collectors.toList());
    }
}

package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipationName {

    public static final String REGEX_COMMA = ",";

    private final String name;

    public ParticipationName(final String name) {

        validate(name);
        this.name = name;
    }

    public static List<ParticipationName> from(final String name) {

        validate(name);
        return split(name);
    }

    private static void validate(final String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("참가자 이름은 필수값입니다.");
        }
    }

    private static List<ParticipationName> split(final String name) {

        return Arrays.stream(name.split(REGEX_COMMA))
                .map(ParticipationName::new)
                .collect(Collectors.toList());
    }
}

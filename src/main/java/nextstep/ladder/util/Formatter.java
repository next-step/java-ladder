package nextstep.ladder.util;

import nextstep.ladder.domain.UserNames;

import java.util.stream.Collectors;

public class Formatter {
    private Formatter() {
        throw new IllegalStateException("Utility class");
    }

    public static String userNamesFormat(final UserNames userNames) {
        return userNames.names().stream()
                .map(s -> String.format("%" + UserNames.NAME_MAX_LENGTH + "s", s))
                .collect(Collectors.joining(" "));
    }
}

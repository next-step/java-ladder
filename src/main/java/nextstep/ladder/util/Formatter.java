package nextstep.ladder.util;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.UserNames;
import nextstep.ladder.domain.UserResults;

import java.util.Arrays;
import java.util.List;
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

    public static String ladderFormat(List<Line> ladderLines) {
        return ladderLines.stream()
                .map(line -> rungFormat(line.getHasRung()))
                .collect(Collectors.joining("\n"));
    }

    private static String rungFormat(Boolean[] rungArr) {
        final String prefix = " ".repeat(UserNames.NAME_MAX_LENGTH - 1) + "|";
        final String delimiter = "|";

        return Arrays.stream(rungArr)
                .map(Formatter::generateLadderPointString)
                .collect(Collectors.joining(delimiter, prefix, delimiter));
    }

    private static String generateLadderPointString(final boolean bool) {
        if (bool) {
            return "-".repeat(UserNames.NAME_MAX_LENGTH);
        }

        return " ".repeat(UserNames.NAME_MAX_LENGTH);
    }

    public static String userResultsFormat(final UserResults userResults) {
        return userResults.results().stream()
                .map(s -> String.format("%" + UserNames.NAME_MAX_LENGTH + "s", s))
                .collect(Collectors.joining(" "));
    }
}

package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LINE_SYMBOL_TRUE = "-----";
    private static final String LINE_SYMBOL_FALSE = "     ";
    private static final String LINE_DELIMITER = "|";
    private final static String LADDER_DELIMITER = "\n";


    public static void printLadderResult(Usernames usernames, Ladder ladder) {
        System.out.println(toStringUsernames(usernames));
        System.out.println(toStringLadder(ladder));
    }

    private static String toStringUsernames(Usernames usernames) {
        return String.join(
                "",
                usernames.getValues()
                        .stream()
                        .map(str -> str.getUsernameForPrint())
                        .collect(Collectors.toList())
        );
    }

    private static String toStringLadder(Ladder ladder) {
        return String.join(
                LADDER_DELIMITER,
                ladder.getLadder()
                        .stream()
                        .map(ResultView::toStringLine)
                        .collect(Collectors.toList())
        );
    }

    private static String toStringLine(Line line) {
        List<String> result = line.getPoints()
                .stream()
                .map(point -> point ? LINE_SYMBOL_TRUE : LINE_SYMBOL_FALSE)
                .collect(Collectors.toList());

        return LINE_DELIMITER + String.join(LINE_DELIMITER, result) + LINE_DELIMITER;
    }
}

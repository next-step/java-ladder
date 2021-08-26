package nextstep.ladder.view;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class LadderConsoleOutput {

    private static final String LADDER_DELIMITER = "|";
    private static final String BAR = "-----";
    private static final String BLANK = "     ";
    private static final String PREFIX_BLANK = "    ";
    private static final String NEXT_LINE = "\n";
    private static final String NONE = "";
    private static final int SUFFIX_CRITERIA = 0;

    public static void print(List<List<Boolean>> ladderBarStatus) {
        System.out.println(ladderBarStatus.stream()
                .map(LadderConsoleOutput::toLadderLine)
                .collect(joining(NEXT_LINE)));
    }

    private static String toLadderLine(final List<Boolean> lineBarStatus) {
        return lineBarStatus.stream()
                .map(LadderConsoleOutput::toBarOrBlank)
                .collect(joining(LADDER_DELIMITER, PREFIX_BLANK + LADDER_DELIMITER, getLineSuffix(lineBarStatus)));
    }

    private static String toBarOrBlank(final boolean status) {
        return status
                ? BAR
                : BLANK;
    }

    private static String getLineSuffix(final List<Boolean> lineBarStatus) {
        return lineBarStatus.size() > SUFFIX_CRITERIA
                ? LADDER_DELIMITER
                : NONE;
    }
}

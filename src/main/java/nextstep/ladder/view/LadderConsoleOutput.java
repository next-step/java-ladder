package nextstep.ladder.view;

import nextstep.ladder.dto.LadderBarStatusDto;
import nextstep.ladder.dto.LineBarStatusDto;

import static java.util.stream.Collectors.joining;

public class LadderConsoleOutput {

    private static final String LADDER_DELIMITER = "|";
    private static final String BAR = "-----";
    private static final String BLANK = "     ";
    private static final String PREFIX_BLANK = "    ";
    private static final String NEXT_LINE = "\n";
    private static final String NONE = "";
    private static final int SUFFIX_CRITERIA = 0;

    public static void print(LadderBarStatusDto barStatus) {
        System.out.println(barStatus.getLineBarStatus()
                .stream()
                .map(LadderConsoleOutput::toLadderLine)
                .collect(joining(NEXT_LINE)));
    }

    private static String toLadderLine(final LineBarStatusDto lineBarStatus) {
        return lineBarStatus.getBarStatus()
                .stream()
                .map(LadderConsoleOutput::toBarOrBlank)
                .collect(joining(LADDER_DELIMITER, PREFIX_BLANK + LADDER_DELIMITER, getLineSuffix(lineBarStatus)));
    }

    private static String toBarOrBlank(final boolean status) {
        return status
                ? BAR
                : BLANK;
    }

    private static String getLineSuffix(final LineBarStatusDto lineBarStatus) {
        return lineBarStatus.isSizeOver(SUFFIX_CRITERIA)
                ? LADDER_DELIMITER
                : NONE;
    }
}

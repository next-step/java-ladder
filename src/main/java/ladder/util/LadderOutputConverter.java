package ladder.util;

import ladder.domain.Result;
import ladder.domain.Results;
import ladder.domain.ladder.HorizontalLineDirection;
import ladder.domain.ladder.ladderline.LadderLine;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.exception.ladder.NoSuchHorizontalLineDirectionException;

import java.util.stream.Collectors;

import static ladder.util.LadderConst.RESULT_DELIMITER;

public class LadderOutputConverter {

    private static final String LADDER_LINE_START_TEXT = "    ";
    private static final String LADDERLINES_DELIMITER = "\n";

    public static String horizontalLineDirectionOutput(HorizontalLineDirection horizontalLineDirection) {
        if (horizontalLineDirection == HorizontalLineDirection.RIGHT) {
            return "|-----";
        }
        if (horizontalLineDirection == HorizontalLineDirection.NONE || horizontalLineDirection == HorizontalLineDirection.LEFT) {
            return "|     ";
        }
        throw new NoSuchHorizontalLineDirectionException();
    }

    public static String ladderLineOutput(LadderLine ladderLine) {
        return (LADDER_LINE_START_TEXT + ladderLine.horizontalLineDirections().stream()
                .map(LadderOutputConverter::horizontalLineDirectionOutput)
                .collect(Collectors.joining()))
                .stripTrailing();
    }

    public static String ladderLinesOutput(LadderLines ladderLines) {
        return ladderLines.ladderLines()
                .stream()
                .map(LadderOutputConverter::ladderLineOutput)
                .collect(Collectors.joining(LADDERLINES_DELIMITER));
    }

    public static String resultOutput(Results results) {
        return results.results().stream()
                .map(LadderOutputConverter::translateResultOutputFormat)
                .collect(Collectors.joining(RESULT_DELIMITER));
    }

    private static String translateResultOutputFormat(Result result) {
        return String.format("%-5s", result.result());
    }
}

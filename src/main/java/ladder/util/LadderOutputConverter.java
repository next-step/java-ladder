package ladder.util;

import ladder.domain.LadderTextInput;
import ladder.domain.Result;
import ladder.domain.ladder.HorizontalLineDirection;
import ladder.domain.ladder.ladderline.LadderLine;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.domain.person.Person;
import ladder.exception.ladder.NoSuchHorizontalLineDirectionException;

import java.util.List;
import java.util.stream.Collectors;

import static ladder.util.LadderConst.*;
import static ladder.util.LadderConst.RESULT_DELIMITER;

public class LadderOutputConverter {

    public static String horizontalLineDirectionOutput(HorizontalLineDirection horizontalLineDirection) {
        if (horizontalLineDirection == HorizontalLineDirection.RIGHT) {
            return LADDER_RIGHT_OUTPUT;
        }
        if (horizontalLineDirection == HorizontalLineDirection.NONE || horizontalLineDirection == HorizontalLineDirection.LEFT) {
            return LADDER_DEFAULT_OUTPUT;
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

    public static String ladderTextOutput(List<LadderTextInput> results) {
        return results.stream()
                .map(LadderOutputConverter::translateResultOutputFormat)
                .collect(Collectors.joining(RESULT_DELIMITER));
    }

    private static String translateResultOutputFormat(LadderTextInput result) {
        return String.format(RESULT_OUTPUT_FORMAT, result.text());
    }

    public static String resultMapOutput(Result resultMap) {
        return resultMap.resultMap().entrySet().stream()
                .map(result -> resultMapFormat(result.getKey(), result.getValue()))
                .collect(Collectors.joining(RESULTMAP_DELIMITER));
    }

    private static String resultMapFormat(Person person, LadderTextInput result) {
        return String.format(RESULTMAP_FORMAT, person.name(), result.text());
    }

    protected static String outputPersonName(String name) {
        if (name.length() < INPUT_LENGTH_MAX) {
            return String.format("%4s ", name);
        }
        return name;
    }
}

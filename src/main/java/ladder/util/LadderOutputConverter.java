package ladder.util;

import ladder.domain.Result;
import ladder.domain.ResultMap;
import ladder.domain.Results;
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

    public static String resultOutput(Results results) {
        return results.results().stream()
                .map(LadderOutputConverter::translateResultOutputFormat)
                .collect(Collectors.joining(RESULT_DELIMITER));
    }

    private static String translateResultOutputFormat(Result result) {
        return String.format(RESULT_OUTPUT_FORMAT, result.result());
    }

    public static String resultMapOutput(ResultMap resultMap, List<Person> resultPersons) {
        return resultPersons.stream()
                .map(person -> resultMapFormat(resultMap.result(person), person))
                .collect(Collectors.joining(RESULTMAP_DELIMITER));
    }

    private static String resultMapFormat(Result result, Person person) {
        return String.format(RESULTMAP_FORMAT, person.name(), result.result());
    }
}

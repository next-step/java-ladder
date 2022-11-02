package ladder.util;

import ladder.domain.Result;
import ladder.domain.Reward;
import ladder.domain.Rewards;
import ladder.domain.ladder.HorizontalLineDirection;
import ladder.domain.ladder.ladderline.LadderLine;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.domain.person.People;
import ladder.domain.person.Person;
import ladder.exception.ladder.NoSuchHorizontalLineDirectionException;

import java.util.stream.Collectors;

import static ladder.util.LadderConst.*;
import static ladder.util.LadderConst.RESULT_DELIMITER;

public class LadderOutputConverter {

    private static final String PEOPLE_NAMES_DELIMITER = " ";

    public static String peopleOutput(People people) {
        return people.people().stream()
                .map(Person::name)
                .collect(Collectors.joining(PEOPLE_NAMES_DELIMITER));
    }

    public static String rewardsOutput(Rewards rewards) {
        return LadderOutputConverter.ladderTextOutput(rewards);
    }

    public static String ladderLinesOutput(LadderLines ladderLines) {
        return ladderLines.ladderLines()
                .stream()
                .map(LadderOutputConverter::ladderLineOutput)
                .collect(Collectors.joining(LADDERLINES_DELIMITER));
    }

    private static String ladderLineOutput(LadderLine ladderLine) {
        return (LADDER_LINE_START_TEXT + ladderLine.horizontalLineDirections().stream()
                .map(LadderOutputConverter::horizontalLineDirectionOutput)
                .collect(Collectors.joining()))
                .stripTrailing();
    }

    private static String horizontalLineDirectionOutput(HorizontalLineDirection horizontalLineDirection) {
        if (horizontalLineDirection == HorizontalLineDirection.RIGHT) {
            return LADDER_RIGHT_OUTPUT;
        }
        if (horizontalLineDirection == HorizontalLineDirection.NONE
                || horizontalLineDirection == HorizontalLineDirection.LEFT) {
            return LADDER_DEFAULT_OUTPUT;
        }
        throw new NoSuchHorizontalLineDirectionException();
    }

    public static String ladderTextOutput(Rewards rewards) {
        return rewards.rewards().stream()
                .map(LadderOutputConverter::translateResultOutputFormat)
                .collect(Collectors.joining(RESULT_DELIMITER));
    }

    private static String translateResultOutputFormat(Reward reward) {
        return String.format(RESULT_OUTPUT_FORMAT, reward.reward());
    }

    public static String resultOutput(Result resultMap) {
        return resultMap.resultMap().entrySet().stream()
                .map(result -> resultMapFormat(result.getKey(), result.getValue()))
                .collect(Collectors.joining(RESULTMAP_DELIMITER));
    }

    private static String resultMapFormat(Person person, Reward result) {
        return String.format(RESULTMAP_FORMAT, person.name(), result.reward());
    }
}

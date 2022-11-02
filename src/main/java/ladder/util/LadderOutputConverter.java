package ladder.util;

import ladder.domain.Result;
import ladder.domain.Reward;
import ladder.domain.Rewards;
import ladder.domain.ladder.MoveHorizontalDirection;
import ladder.domain.ladder.ladderline.LadderLine;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.domain.person.People;
import ladder.domain.person.Person;

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

    private static String horizontalLineDirectionOutput(MoveHorizontalDirection moveHorizontalDirection) {
        if (moveHorizontalDirection.isCurrentRight()) {
            return LADDER_RIGHT_OUTPUT;
        }
        return LADDER_DEFAULT_OUTPUT;
    }

    public static String ladderTextOutput(Rewards rewards) {
        return rewards.rewards().stream()
                .map(LadderOutputConverter::translateResultOutputFormat)
                .collect(Collectors.joining(RESULT_DELIMITER));
    }

    private static String translateResultOutputFormat(Reward reward) {
        return String.format(RESULT_OUTPUT_FORMAT, reward.reward());
    }

    public static String resultOutput(Result result) {
        return result.resultMap().entrySet().stream()
                .map(resultEntry -> resultMapFormat(resultEntry.getKey(), resultEntry.getValue()))
                .collect(Collectors.joining(RESULTMAP_DELIMITER));
    }

    private static String resultMapFormat(Person person, Reward result) {
        return String.format(RESULTMAP_FORMAT, person.name(), result.reward());
    }
}

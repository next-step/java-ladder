package nextstep.step4.result;

import nextstep.step4.domain.Ladder;
import nextstep.step4.domain.Line;
import nextstep.step4.domain.UserInputTexts;

import java.util.List;
import java.util.stream.Collectors;

public class Result {
    public static void printMakingLadderResult(final Ladder ladder) {
        printLadderUserNames(ladder.userNames());
        printLadderBody(ladder.body());
        printLadderReuslts(ladder.userResults());
    }

    private static void printLadderUserNames(final UserInputTexts userInputTexts) {
        final List<String> texts = userInputTexts.getTexts();

        final String printUserNames = texts.stream()
                .map(str -> String.format("%5s", str))
                .collect(Collectors.joining(" "));

        System.out.println(printUserNames);
    }

    private static void printLadderBody(final List<Line> body) {
        throw new UnsupportedOperationException("Result::printLadderBody not implemented yet");
    }

    private static void printLadderReuslts(final UserInputTexts userInputTexts) {
        throw new UnsupportedOperationException("Result::printLadderReuslts not implemented yet");
    }
}

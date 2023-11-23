package nextstep.step4.result;

import nextstep.step4.domain.Ladder;
import nextstep.step4.domain.Line;
import nextstep.step4.domain.UserInputTexts;

import java.util.List;
import java.util.stream.Collectors;

public class Result {
    public static void printMakingLadderResult(final Ladder ladder) {
        printLadderUserInputTexts(ladder.userNames());
        printLadderBody(ladder.body());
        printLadderUserInputTexts(ladder.userResults());
    }

    private static void printLadderUserInputTexts(final UserInputTexts userInputTexts) {
        final List<String> texts = userInputTexts.getTexts();

        final String printUserNames = texts.stream()
                .map(str -> String.format("%5s", str))
                .collect(Collectors.joining(" "));

        System.out.println(printUserNames);
    }

    private static void printLadderBody(final List<Line> body) {
        final String printBody = body.stream()
                .map(Result::printLadderLine)
                .collect(Collectors.joining("\n"));

        System.out.println(printBody);
    }

    private static String printLadderLine(Line line) {
        final String prefix = " ".repeat(UserInputTexts.MAX_TEXT_LENGTH - 1) + "|";
        final String delimiter = "|";

        return line.getHasRungs().stream()
                .map(Result::generateLadderPointString)
                .collect(Collectors.joining(delimiter, prefix, delimiter));
    }

    private static String generateLadderPointString(final boolean bool) {
        if (bool) {
            return "-".repeat(UserInputTexts.MAX_TEXT_LENGTH);
        }

        return " ".repeat(UserInputTexts.MAX_TEXT_LENGTH);
    }
}

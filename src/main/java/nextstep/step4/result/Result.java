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
        final String printBody = body.stream()
                .map(Result::printLadderLine)
                .collect(Collectors.joining("\n"));

        System.out.println(printBody);
    }

    private static String printLadderLine(Line line) {
        final String prefix = " ".repeat(5) + "|";
        final String delimiter = "|";

        return line.getHasRungs().stream()
                .map(Result::generateLadderPointString)
                .collect(Collectors.joining(delimiter, prefix, delimiter));
    }

    private static String generateLadderPointString(final boolean bool) {
        if (bool) {
            return "-".repeat(5);
        }

        return " ".repeat(5);
    }

    private static void printLadderReuslts(final UserInputTexts userInputTexts) {
        throw new UnsupportedOperationException("Result::printLadderReuslts not implemented yet");
    }
}

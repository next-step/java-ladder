package ladder.view;

import ladder.domain.ExpectedResults;
import ladder.domain.Line;
import ladder.domain.Lines;
import ladder.domain.Participants;

import java.util.Optional;

public class ResultView {

    private final static String SPACE_TEXT = " ";
    private final static int DEFAULT_NAME_SPACE_COUNT = 6;
    private final static String LINE_WITH_BRIDGE = "-----|";
    private final static String LINE_WITH_NO_BRIDGE = "     |";

    public void printParticipants(Participants arg) {
        Optional<Participants> participants = Optional.ofNullable(arg);
        participants.ifPresent((netParticipants) ->
                netParticipants.getParticipants()
                        .stream()
                        .map(name -> SPACE_TEXT.repeat(DEFAULT_NAME_SPACE_COUNT - name.getNameSize()) + name)
                        .forEach(System.out::print)
        );
        System.out.println();
    }

    public void printLadder(Lines arg) {
        Optional<Lines> lines = Optional.ofNullable(arg);
        lines.ifPresent(netLines ->
                netLines.getLines()
                        .forEach(this::printLine));
    }

    private void printLine(Line line) {
        line.getPoints()
                .forEach(point -> {
                    String result = LINE_WITH_NO_BRIDGE;
                    if (point) {
                        result = LINE_WITH_BRIDGE;
                    }
                    System.out.print(result);
                });
        System.out.println();
    }

    public void printExpectedResults(ExpectedResults arg) {
        Optional<ExpectedResults> expectedResults = Optional.ofNullable(arg);
        expectedResults.ifPresent((netExpectedResults) ->
                netExpectedResults.getExpectedResults()
                        .stream()
                        .map(expectedResult -> SPACE_TEXT.repeat(DEFAULT_NAME_SPACE_COUNT - expectedResult.getResultSize()) + expectedResult)
                        .forEach(System.out::print)
        );
        System.out.println();
    }
}

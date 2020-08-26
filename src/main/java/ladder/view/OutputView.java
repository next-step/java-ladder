package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Participants;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final int NAME_LENGTH_WIDTH = 6;
    private static final String RESULT_MESSAGE = "\n실행결과\n";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String HORIZONTAL_BLANK = "     ";
    private static final String VERTICAL_LINE = "|";

    public static void printResult(Participants participants, Ladder ladder) {
        System.out.println(RESULT_MESSAGE);

        printParticipants(participants);
        printLadder(ladder);
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLines()
                .stream()
                .map(Line::getConnection)
                .map(OutputView::toLineString)
                .forEach(System.out::println);
    }

    private static String toLineString(List<Boolean> connection) {
        return connection.stream()
                .map(connect -> connect ? HORIZONTAL_LINE : HORIZONTAL_BLANK)
                .map(line -> VERTICAL_LINE + line)
                .collect(Collectors.joining());
    }

    private static void printParticipants(Participants participants) {
        String names = participants.getNames()
                .stream()
                .map(name -> name + repeat(" ", NAME_LENGTH_WIDTH - name.length()))
                .collect(Collectors.joining());

        System.out.println(names);
    }

    private static String repeat(String string, int length) {
        return IntStream.range(0, length)
                .mapToObj(i -> string)
                .collect(Collectors.joining(""));
    }
}

package nextstep.ladder.io;

import nextstep.ladder.dto.Participant;
import nextstep.ladder.enums.Direction;
import nextstep.ladder.game.Ladder;
import nextstep.ladder.game.Row;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String STRING_FORMAT = "%-6s";
    public static final String LINE = "-----";
    public static final String BLANK = "     ";
    public static final String HORIZON = "|";

    private OutputView() {
    }

    public static void println() {
        System.out.println();
    }

    public static void println(Object obj) {
        System.out.println(obj);
    }

    public static void printLadder(List<Participant> participants, Ladder ladder, List<String> results) {
        println("사다리 결과");
        println();

        printParticipants(participants);
        printLadder(ladder);
        printResults(results);

        OutputView.println();
    }

    private static void printParticipants(List<Participant> participants) {
        String participantsString = participants.stream()
                .map(participant -> String.format(STRING_FORMAT, participant))
                .collect(Collectors.joining());

        System.out.println(participantsString);
    }

    private static void printResults(List<String> results) {
        String participantsString = results.stream()
                .map(participant -> String.format(STRING_FORMAT, participant))
                .collect(Collectors.joining());

        System.out.println(participantsString);
    }

    private static void printLadder(Ladder ladder) {
        ladder.getRows().forEach(OutputView::printRow);
    }

    private static void printRow(Row row) {
        String rowsString = row.getDirections().stream()
                .map(OutputView::getDirectionString)
                .collect(Collectors.joining("", BLANK, ""));

        System.out.println(rowsString);
    }

    private static String getDirectionString(Direction direction) {
        return direction == Direction.RIGHT ? HORIZON + LINE : HORIZON + BLANK;
    }
}

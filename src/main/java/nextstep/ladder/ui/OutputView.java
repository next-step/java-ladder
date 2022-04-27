package nextstep.ladder.ui;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participants;

import java.util.List;

public class OutputView {

    public static final String PARTICIPANT_PRINT_FORMAT = "%-6s";
    public static final String BRIDGE = "|-----";
    public static final String EMPTY_BRIDGE = "|     ";

    private OutputView() {
        throw new UnsupportedOperationException();
    }

    public static void printParticipants(Participants participants) {
        participants.getParticipants()
                .forEach(participant -> System.out.printf(PARTICIPANT_PRINT_FORMAT, participant.getName()));
        System.out.println();
    }

    public static void printLines(Lines lines) {
        lines.getLines()
                .forEach(OutputView::printLine);
    }

    private static void printLine(Line line) {
        List<Boolean> bridges = line.getBridges();
        bridges.forEach(bridge -> {
            if (bridge) {
                System.out.print(BRIDGE);
            } else {
                System.out.print(EMPTY_BRIDGE);
            }
        });
        System.out.println();
    }
}

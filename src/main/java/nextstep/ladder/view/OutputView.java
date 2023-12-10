package nextstep.ladder.view;

import java.util.stream.Collectors;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Lines;
import nextstep.ladder.model.Participant;
import nextstep.ladder.model.Participants;

public class OutputView {
    private static final StringBuffer buffer = new StringBuffer();
    private static final String INITIAL_BRIDGE = "     |";
    private static final String PASSABLE_BRIDGE = "-----|";
    private static final String IMPASSABLE_BRIDGE = "     |";

    public static void printLadder(Ladder ladder) {

        buffer.append("\n실행결과\n");
        printParticipants(ladder.getParticipants());
        printLadderLines(ladder.getLines());
        System.out.println(buffer);
    }

    public static void printParticipants(Participants participants) {
        for (Participant participant : participants.getParticipants()) {
            buffer.append(String.format ("%6s", participant.getName()));
        }
        buffer.append("\n");
    }

    private static void printLadderLines(Lines lines) {
        for (Line line : lines.getLines()) {
            buffer.append(INITIAL_BRIDGE);
            printLine(line);
            buffer.append("\n");
        }
    }

    private static void printLine(Line line) {
        buffer.append(
                line.getBridges().stream()
                        .map(bridge -> bridge.canCrossBridge() ? PASSABLE_BRIDGE : IMPASSABLE_BRIDGE)
                        .collect(Collectors.joining()));
    }
}

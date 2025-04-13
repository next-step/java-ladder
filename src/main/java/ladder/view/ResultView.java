package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Participant;
import ladder.domain.Participants;

public class ResultView {

    public static final String VERTICAL_LINE = "|";
    public static final String HORIZONTAL_LINE_CONNECTED = "|-----";
    public static final String HORIZONTAL_LINE = "|     ";

    public void printLadder(Participants participants, Ladder ladder) {
        System.out.println("실행결과");
        printParticipants(participants);
        printLadderLines(ladder);
    }

    private void printParticipants(Participants participants) {
        for (Participant p : participants.list()) {
            System.out.print(getNameFormat(p));
        }
        System.out.println();
    }

    private String getNameFormat(Participant p) {
        return String.format("%-6s", p.getName());
    }

    private void printLadderLines(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            System.out.println(formatLine(line));
        }
    }

    private String formatLine(Line line) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.width(); i++) {
            sb.append(line.isConnected(i) ? HORIZONTAL_LINE_CONNECTED : HORIZONTAL_LINE);
        }
        sb.append(VERTICAL_LINE);
        return sb.toString();
    }
}

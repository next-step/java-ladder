package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Participant;
import ladder.domain.Participants;

public class ResultView {
    public void printLadder(Participants participants, Ladder ladder) {
        System.out.println("실행결과");
        printParticipants(participants);
        printLadderLines(ladder);
    }

    private void printParticipants(Participants participants) {
        for (Participant p : participants.list()) {
            System.out.printf("%-6s", p.getName());
        }
        System.out.println();
    }

    private void printLadderLines(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            System.out.println(formatLine(line));
        }
    }

    private String formatLine(Line line) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.width(); i++) {
            sb.append(line.isConnected(i) ? "|-----" : "|     ");
        }
        sb.append("|");
        return sb.toString();
    }
}

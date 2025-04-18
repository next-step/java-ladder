package ladder.view;

import ladder.domain.*;

public class ResultView {

    public static final String VERTICAL_LINE = "|";
    public static final String HORIZONTAL_LINE_CONNECTED = "|-----";
    public static final String HORIZONTAL_LINE = "|     ";
    public static final String FORMAT_NAMES = "%-6s";

    public void printLadder(Participants participants, Ladder ladder, Results results) {
        System.out.println("실행결과");
        printParticipants(participants);
        printLadderLines(ladder);
        printResults(results);
    }

    private void printParticipants(Participants participants) {
        for (Participant p : participants.list()) {
            System.out.print(getListFormat(p));
        }
        System.out.println();
    }

    private String getListFormat(Participant p) {
        return String.format(FORMAT_NAMES, p.getName());
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

    private void printResults(Results results) {
        for (Result r : results.list()) {
            System.out.print(getListFormat(r));
        }
        System.out.println();
    }


    private String getListFormat(Result p) {
        return String.format(FORMAT_NAMES, p.value());
    }
}

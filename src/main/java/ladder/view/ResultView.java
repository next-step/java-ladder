package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Participants;

public class ResultView {
    private static final String DEFAULT_LINE = "     |";
    private static final String CROSSABLE_LINE = "-----|";
    private static final String ENTER = System.lineSeparator();
    private static final String NAMES_FORMAT = "%5s ";
    private static StringBuilder sb = new StringBuilder();

    private ResultView() {}

    public static void printResult(Participants participants, Ladder ladder) {
        sb.append("실행결과\n");
        printParticipants(sb, participants);
        printLadder(sb, ladder);

        System.out.println(sb);
    }

    private static void printParticipants(StringBuilder sb, Participants participants) {
        sb.append(ENTER);
        participants.getParticipants().forEach(participant -> sb.append(String.format(NAMES_FORMAT, participant.name())));
    }

    private static void printLadder(StringBuilder sb, Ladder ladder) {
        for (Line line : ladder.getLines()) {
            sb.append(ENTER);
            printLine(sb, line);
        }
    }

    private static void printLine(StringBuilder sb, Line line) {
        for (boolean point : line.getPoints()) {
            sb.append(makeLine(point));
        }
    }

    private static String makeLine(boolean point) {
        if (point) {
            return CROSSABLE_LINE;
        }
        return DEFAULT_LINE;
    }
}

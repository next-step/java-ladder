package ladder.view;

import ladder.domain.Line;
import ladder.domain.Lines;
import ladder.domain.Participants;

import java.util.List;

public class ResultView {

    private static final String NOTICE_RESULT = "\n실행결과\n";
    private static final String HORIZONTAL = "|";
    private static final String VERTICAL = "-";
    private static final String VERTICAL_BLANK = " ";

    public static void showResult(Participants participants, Lines lines) {
        System.out.println(NOTICE_RESULT);
        showParticipants(participants);
        showLadders(participants, lines);
    }

    private static void showParticipants(Participants participants) {
        System.out.println(participants.toString());
    }

    private static void showLadders(Participants participants, Lines lines) {
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(createLines(participants, lines.getLine(i)));
        }
    }

    private static String createLines(Participants participants, Line line) {
        List<Boolean> points = line.getPoints();
        StringBuilder builder = new StringBuilder();
        builder.append(HORIZONTAL);
        for (int i = 0; i < points.size(); i++) {
            builder.append(isPoint(points.get(i)).repeat(participants.getParticipant(i).length()));
            builder.append(HORIZONTAL);
        }
        return builder.toString();
    }

    private static String isPoint(Boolean point) {
        if (point) {
            return VERTICAL;
        }
        return VERTICAL_BLANK;
    }
}

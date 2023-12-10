package ladder.view;

import ladder.domain.Line;
import ladder.domain.Lines;
import ladder.domain.Participants;

public class ResultView {

    private static final String NOTICE_RESULT = "\n실행결과\n";
    private static final String HORIZONTAL = "|";
    private static final String VERTICAL = "-----";
    private static final String VERTICAL_BLANK = "     ";

    public static void showResult(Participants participants, Lines lines) {
        System.out.println(NOTICE_RESULT);
        showParticipants(participants);
        showLadders(participants, lines);
    }

    private static void showParticipants(Participants participants) {
        System.out.println(participants.toString());
    }

    private static void showLadders(Participants participants, Lines lines) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lines.size(); i++) {
            builder.setLength(0);
            Line line = lines.getLine(i);
            builder.append(HORIZONTAL);
            line.getPoints().stream()
                            .forEach(point -> builder.append(isPoint(point) + HORIZONTAL));
            System.out.println(builder.toString());
        }
    }

    private static String isPoint(Boolean point) {
        if (point) {
            return VERTICAL;
        }
        return VERTICAL_BLANK;
    }
}

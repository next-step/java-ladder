package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Participants;

import java.util.List;

public class ResultView {

    private static final String NOTICE_LADDERS = "\n사다리 결과\n";
    private static final String HORIZONTAL = "|";
    private static final String VERTICAL = "-----";
    private static final String VERTICAL_BLANK = "     ";
    private static final String NOTICE_RESULT = "\n실행 결과";

    public static void showLadder(Participants participants, Ladder ladder) {
        System.out.println(NOTICE_LADDERS);
        showParticipants(participants);
        showLadder(ladder);
    }

    private static void showParticipants(Participants participants) {
        System.out.println(participants.toString());
    }

    private static void showLadder(Ladder ladder) {
        for (int i = 0; i < ladder.size(); i++) {
            System.out.println(createLines(ladder.getLine(i)));
        }
        System.out.println(ladder.getResultsData());
    }

    private static String createLines(Line line) {
        List<Boolean> points = line.getPoints();
        StringBuilder builder = new StringBuilder();
        builder.append(HORIZONTAL);
        for (int i = 0; i < points.size(); i++) {
            builder.append(isPoint(points.get(i)));
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

    public static void showResult(String result) {
        System.out.println(NOTICE_RESULT);
        System.out.println(result);
    }
}

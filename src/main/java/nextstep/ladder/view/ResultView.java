package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Point;

public class ResultView {
    private static final String LINE = "|";
    private static final String LADDER_LINE = "-----";
    private static final String LADDER_EMPTY = "     ";
    private static final String RESULT_PLAY = "\n실행결과\n";

    private ResultView() {
    }

    public static void ladderView(Ladder ladder, Participants participants) {
        System.out.println(RESULT_PLAY);

        participants.getParticipants().forEach(p -> {
            int spacesToAdd = 6 - p.getParticipant().length();
            System.out.print(p.getParticipant() + " ".repeat(spacesToAdd));
        });
        System.out.println();
        ladder.getLines().forEach(ResultView::drawLadder);
    }

    private static void drawLadder(Line line) {
        System.out.print(LINE);
        StringBuilder printLine = new StringBuilder();
        for (int i=0; i<line.getPoints().size(); i++) {
            printLine.append(drawStair(line.getPoints().get(i)));
        }
        System.out.println(printLine);
    }

    private static String drawStair(Point point) {
        if (point.getIsStair()) {
            return LADDER_LINE + LINE;
        }
        return LADDER_EMPTY + LINE;
    }
}

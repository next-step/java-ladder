package reladder.view;

import reladder.domain.Ladder;
import reladder.domain.LadderLine;
import reladder.domain.Point;

public class ResultView {

    private static final String LADDER_LINE = "|     ";
    private static final String LADDER_POINT = "|-----";
    private static final String INTERVAL = " ";

    public static void drawLadder(Ladder ladder) {
        for (LadderLine ladderLine : ladder.getLadderLines()) {
            for (Point point : ladderLine.getPoints()) {
                if (!point.isLeft() && point.isRight()) {
                    System.out.print(LADDER_POINT);
                } else {
                    System.out.print(LADDER_LINE);
                }
            }
            System.out.println();
        }
    }
}

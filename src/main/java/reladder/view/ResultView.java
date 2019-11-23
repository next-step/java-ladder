package reladder.view;

import reladder.domain.Ladder;
import reladder.domain.LadderLine;
import reladder.domain.Point;

import java.util.List;

public class ResultView {

    private static final String LADDER_LINE = "|     ";
    private static final String LADDER_POINT = "|-----";
    private static final String INTERVAL = " ";

    public static void drawLadder(List<LadderLine> ladderLines) {
        for (LadderLine ladderLine : ladderLines) {
            drawLadderLine(ladderLine.getPoints());
        }
    }

    private static void drawLadderLine(List<Point> points) {
        for (Point point : points) {
            System.out.print(drawPoint(point));
        }
        System.out.println();
    }

    private static String drawPoint(Point point){
        if (!point.isLeft() && point.isRight()) {
            return LADDER_POINT;
        }
        return LADDER_LINE;
    }
}

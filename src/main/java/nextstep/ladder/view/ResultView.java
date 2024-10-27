package nextstep.ladder.view;

import nextstep.ladder.model.Gamers;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Point;

import java.util.Map;

public class ResultView {
    private static final int LADDER_POINT_COUNT = 5;
    private static final Map<Boolean, String> LADDER_SEGMENTS = Map.of(
            true, "-".repeat(LADDER_POINT_COUNT),
            false, " ".repeat(LADDER_POINT_COUNT)
    );

    public void printResult(Gamers gamers, Ladder ladder) {
        System.out.println("\n\n실행 결과\n");
        System.out.println(gamers.getGamers());
        ladder.getLines().forEach(this::printLadderLine);
    }

    private static void printLadderPoint(Point point) {
        System.out.print(LADDER_SEGMENTS.get(point.getValue()) + "|");
    }

    private void printLadderLine(Line line) {
        System.out.print("|");
        line.getPoints().forEach(ResultView::printLadderPoint);
        System.out.println();
    }
}

package nextstep.step4.ladder.domain;

import java.util.*;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-05 02:03
 */
public class LadderFactory {

    public static final int NEXT_INDEX = 1;
    public static final int LAST_INDEX = 1;

    public static Ladder create(int row, int line) {
        List<LadderLine> lines = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            lines.add(createLine(line));
        }
        return new Ladder(lines);
    }

    private static LadderLine createLine(int line) {
        List<Point> points = new ArrayList<>();
        points.add(Point.first(() -> random()));
        for (int i = NEXT_INDEX; i < line - LAST_INDEX; i++) {
            points.add(nextLink(points.get(i - NEXT_INDEX)));
        }
        points.add(Point.last(points.get(points.size() - LAST_INDEX)));
        return new LadderLine(points);
    }

    private static Point nextLink(Point leftPoint) {
        return leftPoint.next(() -> random());
    }

    private static boolean random() {
        return new Random().nextBoolean();
    }
}

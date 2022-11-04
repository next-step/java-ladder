package ladder.fixtures;

import ladder.domain.*;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LadderFixtures {

    public static Ladder createLadder() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, Direction.first(true)));
        points.add(new Point(1, Direction.of(true, false)));
        points.add(new Point(2, Direction.of(false, true)));
        points.add(new Point(3, Direction.of(true, false)));

        List<Point> points2 = new ArrayList<>();
        points2.add(new Point(0, Direction.first(false)));
        points2.add(new Point(1, Direction.of(false, true)));
        points2.add(new Point(2, Direction.of(true, false)));
        points2.add(new Point(3, Direction.of(false, false)));

        List<LadderLine> lines = new ArrayList<>();
        lines.add(new LadderLine(points));
        lines.add(new LadderLine(points2));
        lines.add(new LadderLine(points));
        lines.add(new LadderLine(points2));
        lines.add(new LadderLine(points));

        return new Ladder(lines);
    }

    public static Ladder createLadder2() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, Direction.first(true)));
        points.add(new Point(1, Direction.of(true, false)));
        points.add(new Point(2, Direction.of(false, true)));
        points.add(new Point(3, Direction.of(true, false)));

        List<Point> points2 = new ArrayList<>();
        points2.add(new Point(0, Direction.first(false)));
        points2.add(new Point(1, Direction.of(false, true)));
        points2.add(new Point(2, Direction.of(true, false)));
        points2.add(new Point(3, Direction.of(false, false)));

        List<LadderLine> lines = new ArrayList<>();
        lines.add(new LadderLine(points));
        lines.add(new LadderLine(points2));
        lines.add(new LadderLine(points));
        lines.add(new LadderLine(points2));
        lines.add(new LadderLine(points));

        return new Ladder(lines);
    }
}

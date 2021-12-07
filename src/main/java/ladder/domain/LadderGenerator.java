package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {

    public static final List<Line> lines = new ArrayList<>();

    public static Ladder createLadder(Players players, Height height) {
        for (int i = 0; i < height.getHeight(); i++) {
            List<Direction> directions = Direction.of(players.getPlayers().size());
            lines.add(createLine(players, directions));
        }
        return new Ladder(lines);
    }

    private static Line createLine(Players players, List<Direction> directions) {
        List<Point> points = new ArrayList<>();
        for (int j = 0; j < players.getPlayers().size() ; j++) {
            points.add(new Point(new Position(j), directions.get(j)));
        }
        return new Line(points);
    }

}

package ladder.domain.ladder;

import ladder.strategy.LineStrategy;
import ladder.strategy.RandomLineStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderRow {

    private static final LineStrategy DEFAULT_STRATEGY = new RandomLineStrategy();
    private static final int MOVE_INSTANCE_UNIT = 1;
    private List<Point> lines;

    public LadderRow(List<Point> lines) {
        this.lines = lines;
    }

    public LadderRow(int countOfPlayers) {
        lines = generateLines(countOfPlayers);
    }
    public List<Point> getLines() {
        return Collections.unmodifiableList(lines);
    }

    private List<Point> generateLines(int countOfPlayers) {
        final List<Point> newLines = new ArrayList<>();
        newLines.add(Point.first(DEFAULT_STRATEGY));
        for (int i = 1; i < countOfPlayers - 1; i++) {
            newLines.add(generateLine(newLines.get(i - 1)));
        }
        newLines.add(newLines.get(countOfPlayers - 2).last());

        return newLines;
    }

    private Point generateLine(Point point) {
        return point.next(DEFAULT_STRATEGY);
    }

    public int move(int position) {
        Point point = lines.get(position);
        Direction direction = point.move();
        return toDistance(direction, position);
    }

    private int toDistance(Direction direction, int position) {
        if (Direction.RIGHT.equals(direction)) {
            return position + MOVE_INSTANCE_UNIT;
        }
        if (Direction.LEFT.equals(direction)) {
            return position - MOVE_INSTANCE_UNIT;
        }
        return position;
    }

    public int size() {
        return lines.size();
    }
}

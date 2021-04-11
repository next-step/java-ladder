package nextstep.ladder.entity;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public Lines(int userCount, DrawRule drawRule) {
        this(initLines(userCount, drawRule));
    }

    public Lines(int userCount) {
        this(initLines(userCount, new RandomDrawRule()));
    }

    public Line positionLine(int position) {
        return lines.get(position);
    }

    public int getLineSize() {
        return lines.size();
    }

    private static List<Line> initLines(int userCount, DrawRule rule) {

        List<Line> list = new ArrayList<>();
        Direction direction = Direction.NONE;

        for (int i = 0; i < userCount - 1; i++) {
            Line line = new Line(direction, rule);
            direction = line.getLineDirection();
            list.add(line);
        }

        list.add(new Line(direction, new LastPointNoneDrawRule()));

        return list;
    }
}

package nextstep.ladder.entity;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public Lines(int userCount) {
        this(initLines(userCount));
    }

    public List<Line> getLines() {
        return lines;
    }

    private static List<Line> initLines(int userCount) {

        Direction direction = Direction.NONE;

        List<Line> list = new ArrayList<>();

        for (int i = 0; i < userCount; i++) {
            Line line = new Line(direction);
            direction = line.getLineDirection();
            list.add(line);
        }

        return list;
    }
}

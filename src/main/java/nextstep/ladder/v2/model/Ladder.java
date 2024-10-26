package nextstep.ladder.v2.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder empty() {
        return new Ladder(new ArrayList<>());
    }

    public void createALine(int countOfPlayers, PointGenerator pointGenerator) {
        Line line = new Line(countOfPlayers, pointGenerator);
        this.lines.add(line);
    }

    public int move(int startPosition) {
        return lines.stream()
                .reduce(startPosition,
                        (result, line) -> line.move(result),
                        (result1, result2) -> result1);
    }

    public List<Line> getLines() {
        return lines;
    }
}

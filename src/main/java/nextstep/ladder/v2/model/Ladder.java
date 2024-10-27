package nextstep.ladder.v2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> lines;
    private int countOfPlayers;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Ladder(int countOfPlayers) {
        this.countOfPlayers = countOfPlayers;
        this.lines = new ArrayList<>();
    }

    public static Ladder of(int countOfPlayers) {
        return new Ladder(countOfPlayers);
    }

    public Ladder createLadder(int height, PointGenerator pointGenerator) {
        this.lines = IntStream.range(0, height)
                .mapToObj(it -> createLine(this.countOfPlayers, pointGenerator))
                .collect(Collectors.toList());
        return this;
    }

    public Line createLine(int countOfPlayers, PointGenerator pointGenerator) {
        Line line = new Line(countOfPlayers, pointGenerator);
        return line;
    }

    public void createALine(int countOfPlayers, PointGenerator pointGenerator) {
        Line line = new Line(countOfPlayers, pointGenerator);
        this.lines.add(line);
    }

    public int move(int startPosition) {
        return lines.stream()
                .reduce(startPosition,
                        (position, line) -> line.move(position),
                        (nextPosition1, nextPosition2) -> nextPosition1);
    }

    public List<Line> getLines() {
        return lines;
    }
}

package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    private LineGenerator lineGenerator;

    public Line(int countOfPlayers, LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
        IntStream.range(0, countOfPlayers - 1)
                .forEach(it -> this.points.add(makeLine(it)));
    }

    private boolean makeLine(int i) {
        return i == 0 ? this.lineGenerator.generate() : !points.get(i - 1) && this.lineGenerator.generate();
    }

    public List<Boolean> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}

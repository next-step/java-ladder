package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    private LineGenerateStrategy lineGenerateStrategy;

    public Line(List<Boolean> points) {
        this(points, new RandomLineGenerator());
    }

    public Line(List<Boolean> points, LineGenerateStrategy lineGenerateStrategy) {
        this.points = points;
        this.lineGenerateStrategy = lineGenerateStrategy;
    }

    public Line(int countOfPerson, LineGenerateStrategy lineGenerateStrategy) {
        this.lineGenerateStrategy = lineGenerateStrategy;
        generatePoints(countOfPerson);
    }

    private void generatePoints(int countOfPerson) {

        boolean isPrevLineConnected = false;
        for (int i = 0; i < countOfPerson - 1; i++) {
            boolean currentLineConnection = !isPrevLineConnected && lineGenerateStrategy.generate();
            points.add(currentLineConnection);
            isPrevLineConnected = currentLineConnection;
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}

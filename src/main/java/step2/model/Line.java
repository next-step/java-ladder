package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {
    private final List<Point> points;

    public Line(int numberOfUser, LadderStrategy ladderStrategy) {
        points = new ArrayList<>();

        for (int i = 0; i < numberOfUser; i++) {
            drawPoint(ladderStrategy, i);
        }

    }

    public Line(List<Point> points) {
        this.points = points;
    }

    public List<Boolean> getLine() {
        return this.points.stream()
                            .map(Point::getPoint)
                            .collect(Collectors.toList());
    }

    private int drawPoint(LadderStrategy ladderStrategy, int index) {
        boolean isPoint = ladderStrategy.generateLine();
        if (index != 0 && getLast()) {
            isPoint = false;
        }

        points.add(new Point(isPoint));
        return index;
    }

    public GameResults checkPoint(GameResults gameResults) {
        List<GameResult> result = new ArrayList<>();

        for (int i = 0; i < points.size(); i++) {
            i = switchResult(result, gameResults, i);
        }

        return new GameResults(result);
    }

    private int switchResult(List<GameResult> result, GameResults gameResults, int index) {
        if (!isLast(index) && points.get(index).getPoint()) {
            User currentUser = gameResults.getUser(index);
            User nextUser = gameResults.getGameResult(index+1).getUser();
            Result currentResult = gameResults.getResult(index);
            Result nextResult = gameResults.getGameResult(index + 1).getResult();

            result.add(new GameResult(currentUser, nextResult));
            result.add(new GameResult(nextUser, currentResult));

            return index + 1;
        }

        result.add(gameResults.getGameResult(index));
        return index;
    }

    private boolean isLast(int index) {
        return index == points.size() - 1;
    }

    private boolean getLast() {
        return points.get(points.size() - 1).getPoint();
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
        return Objects.hash(points);
    }
}

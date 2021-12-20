package ladder.domain;


import java.util.List;

public class Line {
    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line of(PointsStrategy pointsStrategy) {
        return new Line(pointsStrategy.points());
    }

    public int move(int point, boolean[] visited) {
        visited[point] = true;
        if (isMoveRight(point, visited)) {
            return move(point + 1, visited);
        }

        if (isMoveLeft(point, visited)) {
            return move(point - 1, visited);
        }
        return point;
    }

    public boolean isMoveRight(int point, boolean[] visited) {
        return point < points.size() - 1 && !visited[point + 1] && hasRightLine(point);
    }

    public boolean isMoveLeft(int point, boolean[] visited) {
        return point >= 1 && !visited[point - 1] && hasRightLine(point - 1);
    }

    public int numberOfPoints() {
        return points.size();
    }

    public boolean hasRightLine(int point) {
        return points.get(point);
    }

}

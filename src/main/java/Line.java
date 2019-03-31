import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        verifyCountOfPerson(points);
        verifyValidLine(points);
        this.points = points;
    }

    private void verifyCountOfPerson(List<Point> points) {
        if(points.size() < 2) {
            throw new IllegalArgumentException("사다리게임은 두 명이상부터만 가능합니다.");
        }
    }

    private void verifyValidLine(List<Point> points) {
        for(int i=1; i<points.size(); i++) {
            verifyValidPoint(points.get(i-1), points.get(i));
        }
    }

    private void verifyValidPoint(Point previous, Point next) {
        if(previous.isLinked() && next.isLinked()) {
            throw new IllegalArgumentException("사다리게임의 규칙을 위배하여 생성할 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        points.forEach(sb::append);
        return sb.toString();
    }

    public int getNumberOfPoints() {
        return points.size();
    }

    public boolean matchCountOfPoint(Line line) {
        return line.points.size() == this.points.size();
    }
}
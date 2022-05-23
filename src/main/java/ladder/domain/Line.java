package ladder.domain;

import ladder.strategy.LineStrategy;

import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        validateEmpty(points);
        validateOverlap(points);

        this.points = points;
    }

    public static Line of(int countOfParticipants, LineStrategy lineStrategy) {
        return new Line(lineStrategy.initialPoints(countOfParticipants));
    }

    public static Line from(List<Boolean> points) {
        return new Line(points);
    }

    public Position movedFrom(Position position) {
        if (position.isOver(points.size() - 1)) {
            throw new IllegalArgumentException("더 이상 이동할 수 없습니다.");
        }
        if (movableLeftFrom(position)) {
            return position.movedBackward();
        }
        if (movableRightFrom(position)) {
            return position.movedForward();
        }
        return position;
    }

    private boolean movableLeftFrom(Position position) {
        if (position.isFirst()) { // 라인의 맨 왼쪽인 경우 왼쪽으로 더이상 갈 수 없음.
            return false;
        }
        return points.get(position.now()); // ex)'      |-----|' 왼쪽으로 이동가능한 경우
    }

    private boolean movableRightFrom(Position position) {
        if (position.isLast(points.size() - 1)) { // 라인의 맨 오른쪽인 경우 오른쪽으로 더이상 갈 수 없음.
            return false;
        }
        return points.get(position.forward());
    }

    private void validateEmpty(List<Boolean> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("좌표값들이 존재하지 않습니다.");
        }
    }

    private void validateOverlap(List<Boolean> points) {
        int bound = points.size() - 1;
        for (int i = 0; i < bound; i++) {
            compareWithNextPoint(points, i);
        }
    }

    private void compareWithNextPoint(List<Boolean> points, int index) {
        if (overlapped(points, index)) {
            throw new IllegalArgumentException("라인 겹치는 경우는 존재할 수 없습니다.");
        }
    }

    private boolean overlapped(List<Boolean> points, int index) {
        return points.get(index) && points.get(index) == points.get(index + 1);
    }

    public List<Boolean> getPoints() {
        return List.copyOf(points);
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

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}

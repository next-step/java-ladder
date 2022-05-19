package ladder.domain;

import java.util.List;

public class Line {
    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        validateEmpty(points);
        validateOverlap(points);

        this.points = points;
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

    public static Line of(int countOfParticipants, LineStrategy lineStrategy) {
        return new Line(lineStrategy.initialPoints(countOfParticipants));
    }

    public static Line from(List<Boolean> points) {
        return new Line(points);
    }

    public List<Boolean> getPoints() {
        return List.copyOf(points);
    }
}

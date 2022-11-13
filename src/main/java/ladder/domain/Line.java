package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
    }

    public Line(List<Boolean> points) {
        validPoints(points);
        this.points.addAll(points);
    }

    private void validPoints(List<Boolean> points) {
        if (points == null || points.size() == 0) {
            throw new IllegalArgumentException("포인트는 하나이상 있어야 합니다.");
        }
        validFirstPoint(points);
        validLinks(points);
    }
    private void validFirstPoint(List<Boolean> points) {
        boolean firstPoints = points.get(0);
        if (firstPoints) {
            throw new IllegalArgumentException("첫번째 포인트는 연결선(true)일수 없습니다.");
        }
    }

    private void validLinks(List<Boolean> points) {
        if (points.size() == 1) {
            return;
        }
        for (int i = 0; i < points.size() - 1; i++) {
            Boolean currentPoint = points.get(i);
            Boolean nextPoint = points.get(i + 1);
            if (currentPoint && nextPoint) {
                throw new IllegalArgumentException("연속해서 연결선이 올수 없습니다.");
            }
        }
    }

    public int linkSize() {
        return (int) points.stream()
                .filter(point -> point)
                .count();
    }
}

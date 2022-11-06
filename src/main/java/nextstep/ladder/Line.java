package nextstep.ladder;

import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        if (points == null || points.size() <= 1) {
            throw new IllegalArgumentException("연결 지점들이 null이거나 갯수가 너무 작습니다.");
        }

        for (int i = 1; i < points.size(); i++) {
            validateTwoPoints(points, i);
        }

        this.points = points;
    }

    private static void validateTwoPoints(List<Boolean> points, int i) {
        if (points.get(i - 1) && points.get(i)) {
            throw new IllegalArgumentException("연속해서 두 지점이 연결되어있을 수 없습니다.");
        }
    }

    public boolean connected(int index) {
        if (index < 0 || index >= points.size()) {
            throw new IllegalArgumentException("조회 위치가 범위를 초과하였습니다.");
        }
        return points.get(index);
    }

    public int size() {
        return points.size();
    }
}

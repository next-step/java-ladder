package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {

    private List<Boolean> points = new ArrayList<>();

    private Line() {

    }

    private Line(List<Boolean> points) {
        validPointsCount(points);
        validContinuous(points);

        this.points = points;
    }

    public static Line from(Boolean... existPoint) {
        return new Line(
                Arrays.stream(existPoint)
                        .collect(Collectors.toList()));
    }

    private void validContinuous(List<Boolean> points) {
        boolean temp = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            if (temp && points.get(i)) {
                throw new IllegalArgumentException("가로 선은 연속해서 2개 이상 위치할 수 없습니다.");
            }
            temp = points.get(i);
        }
    }

    private void validPointsCount(List<Boolean> points) {
        if (points.size() < 2) {
            throw new IllegalArgumentException("포인트 갯수는 최소 2개 이상 이어야합니다." + "현재 : " + points.size());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}

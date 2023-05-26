package step3.domain;

import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfPerson) {
        this(countOfPerson, DefalutLineBuildStrategy.getInstance());
    }

    public Line(int countOfPerson, LineBuildStrategy lineBuildStrategy) {
        List<Boolean> points = makePoints(countOfPerson, lineBuildStrategy);
        validatePoints(points);
        this.points = points;
    }

    private void validatePoints(List<Boolean> points) {
        for (int i = 1; i < points.size(); i++) {
            isThereConsecutiveTrue(points.get(i - 1), points.get(i));
        }
    }

    private void isThereConsecutiveTrue(boolean line1, boolean line2) {
        if (line1 && line2) {
            throw new IllegalStateException("연속된 가로줄은 있을 수 없습니다.");
        }
    }

    private List<Boolean> makePoints(int countOfPerson, LineBuildStrategy lineBuildStrategy) {
        return lineBuildStrategy.build(countOfPerson);
    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}

package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final String INVALID_LINE_LENGTH = "Line 길이는 2이상으로 생성 할 수 있습니다.";
    private List<Boolean> points;

    public Line(int length, GenerableStrategy generableStrategy) {
        validateLength(length);
        points = generableStrategy.generate(length);
    }

    private void validateLength(int length) {
        if (length < 1) {
            throw new IllegalArgumentException(INVALID_LINE_LENGTH);
        }
    }

    public int getLadderLength() {
        return points.size();
    }

    public List<Boolean> getLine() {
        List<Boolean> deepCopiedPoints = new ArrayList<>();
        deepCopiedPoints.addAll(points);
        return deepCopiedPoints;
    }

    @Override
    public String toString() {
        return "Line{" +
            "points=" + points +
            '}';
    }
}

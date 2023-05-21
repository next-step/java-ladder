package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> points;

    public Line(Supplier<List<Boolean>> supplierPoints) {
        this.points = supplierPoints.get();
    }

    public boolean hasLeftPoint(int currentPlayerPoint) {
        if (currentPlayerPoint == 0) {
            return false;
        }
        return points.get(currentPlayerPoint - 1);
    }

    public boolean hasRightPoint(int currentPlayerPoint) {
        if (points.size() == currentPlayerPoint || points.size() < currentPlayerPoint) {
            return false;
        }
        return points.get(currentPlayerPoint);
    }

    public List<Boolean> getPoints() {
        return points;
    }

}

package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.BridgeStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {
    private final List<Boolean> points;

    public Line(int width, BridgeStrategy strategy) {
        this.points = generatePoints(width, strategy);
        validateDuplicate();
    }

    protected Line(List<Boolean> points) {
        this.points = List.copyOf(points);
    }

    private List<Boolean> generatePoints(int width, BridgeStrategy strategy) {
        return Stream.generate(strategy::makeBridge)
                .limit(width - 1)
                .collect(Collectors.toList());
    }

    private void validateDuplicate() {
        for (int i = 1; i < points.size(); i++) {
            setFalseIfPreviousHasBridge(i);
            throwExceptionWhenDuplicateBridgeExists(i);
        }
    }

    private void setFalseIfPreviousHasBridge(int index) {
        if (hasDuplicate(index)) {
            points.set(index, false);
        }
    }

    private void throwExceptionWhenDuplicateBridgeExists(int index) {
        if (hasDuplicate(index)) {
            throw new IllegalArgumentException("중복된 다리가 있습니다.");
        }
    }

    private boolean hasDuplicate(int index) {
        return points.get(index - 1) && points.get(index);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public boolean get(int index) {
        return points.get(index);
    }
}

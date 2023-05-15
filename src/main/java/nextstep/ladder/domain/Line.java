package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.BridgeStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final BridgeStrategy strategy;
    private final List<Boolean> points;

    public Line(int width, BridgeStrategy strategy) {
        validate(width);
        this.strategy = strategy;
        this.points = generatePoints(width);
        validateDuplicate();
    }

    private void validate(int width) {
        if (width < 1) {
            throw new IllegalArgumentException("넓이는 1 이상이여야 합니다.");
        }
    }

    private List<Boolean> generatePoints(int width) {
        return IntStream.rangeClosed(0, width)
                .mapToObj(i -> strategy.makeBridge())
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
}

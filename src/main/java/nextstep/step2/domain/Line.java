package nextstep.step2.domain;

import nextstep.step2.vo.BooleanGenerateStrategy;
import nextstep.step2.vo.Bridge;
import nextstep.step2.vo.Width;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final String NOT_EMPTY_LINE_MESSAGE = "빈 값으로 생성할 수 없습니다.";
    private static final int SECOND_BRIDGE = 1;
    private static final int ONE_TO_CALCULATE_END_LINE = 1;
    private static final int PREV_IDX = 1;

    private final List<Bridge> bridges;

    private Line(List<Bridge> bridges) {
        if (bridges == null || bridges.isEmpty()) {
            throw new IllegalArgumentException(NOT_EMPTY_LINE_MESSAGE);
        }
        this.bridges = new ArrayList<>(bridges);
    }

    public static Line from(List<Bridge> bridges) {
        return new Line(bridges);
    }

    public static Line fromWithLine(Line line) {
        return from(line.bridges);
    }

    public static Line ofWithWidthAndStrategy(Width width, BooleanGenerateStrategy strategy) {
        return ofWithEndLineAndStrategy(width.getValue(), strategy);
    }

    public static Line ofWithEndLineAndStrategy(int endLine, BooleanGenerateStrategy strategy) {
        List<Bridge> bridges = new ArrayList<>();
        bridges.add(Bridge.firstBridge(strategy.generate()));

        for (int i = SECOND_BRIDGE; i < endLine; i++) {
            Bridge prev = bridges.get(i - PREV_IDX);
            bridges.add(prev.nextBridge(strategy.generate(), isLast(i, endLine)));
        }

        return from(bridges);
    }

    private static boolean isLast(int now, int endLine) {
        return now == endLine - ONE_TO_CALCULATE_END_LINE;
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(bridges, line.bridges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bridges);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + bridges +
                '}';
    }

    public Point move(Point before) {
        return before.movedPoint(findBridge(before));
    }

    private Bridge findBridge(Point before) {
        return bridges.get(before.getValue());
    }
}

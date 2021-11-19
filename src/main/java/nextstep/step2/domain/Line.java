package nextstep.step2.domain;

import nextstep.step2.vo.BooleanGenerateStrategy;
import nextstep.step2.vo.Bridge;
import nextstep.step2.vo.Width;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int START_LINE = 0;
    private static final int ONE_TO_CALCULATE_END_LINE = 1;

    private final List<Bridge> bridges;

    private Line(List<Bridge> bridges) {
        this.bridges = new ArrayList<>(bridges);
    }

    public static Line create(List<Bridge> bridges) {
        return new Line(bridges);
    }

    public static Line createWithLine(Line line) {
        return new Line(line.bridges);
    }

    public static Line createWithEndLine(int endLine, BooleanGenerateStrategy strategy) {
        List<Bridge> bridges = new ArrayList<>();
        for (int i = START_LINE; i < endLine; i++) {
            bridges.add(makePoint(strategy, bridges));
        }

        return new Line(bridges);
    }

    public static Line createWithWidth(Width width, BooleanGenerateStrategy strategy) {
        return createWithEndLine(getEndLine(width), strategy);
    }

    private static int getEndLine(Width width) {
        return width.getValue() - ONE_TO_CALCULATE_END_LINE;
    }

    private static Bridge makePoint(BooleanGenerateStrategy strategy, List<Bridge> bridges) {
        if (bridges.isEmpty()) {
            return Bridge.create(strategy.generate());
        }

        int now = bridges.size() - 1;
        if (bridges.get(now).equals(Bridge.TRUE)) {
            return Bridge.FALSE;
        }

        return Bridge.create(strategy.generate());
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
}

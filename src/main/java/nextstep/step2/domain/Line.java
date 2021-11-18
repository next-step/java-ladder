package nextstep.step2.domain;

import nextstep.step2.vo.BooleanGenerateStrategy;
import nextstep.step2.vo.Bridge;
import nextstep.step2.vo.Width;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {
    private static final int START_LINE = 0;

    private final List<Bridge> bridges;

    private Line(List<Bridge> bridges) {
        this.bridges = bridges;
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
        return createWithEndLine(width.getEndLine(), strategy);
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
        return bridges.stream()
                .map(Bridge::getValue)
                .map(Bridge::create)
                .collect(Collectors.toList());
    }

    public int size() {
        return bridges.size();
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

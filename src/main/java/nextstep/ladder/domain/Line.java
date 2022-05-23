package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import nextstep.ladder.exception.LadderExceptionCode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> bars;

    public static Line init(Height height) {
        if (height == null) {
            throw new LadderException(LadderExceptionCode.INVALID_HEIGHT);
        }
        return new Line(
                IntStream.range(0, height.getHeight())
                        .mapToObj(i -> Boolean.FALSE)
                        .collect(Collectors.toList())
        );
    }

    public static Line of(List<Boolean> bars) {
        return new Line(bars);
    }

    private Line(List<Boolean> bars) {
        this.bars = bars;
    }

    public void createWith(Line compare) {
        bars = compare.getBars()
                .stream()
                .map(this::calculate)
                .collect(Collectors.toList());
    }

    private Boolean calculate(Boolean comparedPoint) {
        return comparedPoint ? false : randomBoolean();
    }

    private boolean randomBoolean() {
        boolean[] booleans = new boolean[]{false, true, true};
        return booleans[new Random().nextInt(3)];
    }

    public Boolean bar(int index) {
        return getBars().get(index);
    }

    private List<Boolean> getBars() {
        return bars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(bars, line.bars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bars);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + bars +
                '}';
    }
}

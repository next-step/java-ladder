package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {
    private final List<Rung> rungs;

    public Line(int size, RungGenerator generator) {
        this(generateRungs(size, generator));
    }

    public Line(boolean... line) {
        this(toRungs(line));
    }

    public Line(List<Rung> rungs) {
        this.rungs = rungs;
    }

    private static List<Rung> toRungs(boolean[] line) {
        return IntStream.range(0, line.length)
                .mapToObj(i -> new Rung(line[i]))
                .collect(Collectors.toList());
    }

    private static List<Rung> generateRungs(int size, RungGenerator generator) {
        if (size < 1) {
            throw new IllegalArgumentException("Line size should be greater than 0");
        }

        return Stream.iterate(Rung.create(generator), previous -> previous.createNext(generator))
                .limit(size)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Rung> getRungs() {
        return Collections.unmodifiableList(rungs);
    }

    public boolean hasSameWidth(int width) {
        return rungs.size() == width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line1 = (Line) o;
        return Objects.equals(rungs, line1.rungs);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(rungs);
    }

    public int moveFrom(int point) {
        if (isMoveToLeft(point)) return point - 1;
        if (isMoveToRight(point)) return point + 1;
        return point;
    }

    private boolean isMoveToLeft(int point) {
        return point > 0 && rungs.get(point - 1).isConnected();
    }

    private boolean isMoveToRight(int point) {
        return point < rungs.size() && rungs.get(point).isConnected();
    }
}

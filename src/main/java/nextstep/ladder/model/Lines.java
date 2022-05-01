package nextstep.ladder.model;

import nextstep.common.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Lines {

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        Assert.notEmpty(lines, "lines must not be empty");
        this.lines = new ArrayList<>(lines);
    }

    public static Lines of(Positive height, LineGenerator generator) {
        Assert.notNull(height, "height must not be null");
        Assert.notNull(generator, "generator must not be null");
        List<Line> lines = new ArrayList<>();
        for (Positive index = Positive.ONE; index.lessThanOrEqual(height); index = index.add(Positive.ONE)) {
            lines.add(generator.line());
        }
        return new Lines(lines);
    }

    public List<Line> list() {
        return Collections.unmodifiableList(lines);
    }

    boolean hasDifferentPointSize(int size) {
        return lines.get(0).hasDifferentSize(size);
    }

    public int lastMovedIndex(int startIndex) {
        int currentIndex = startIndex;
        for (Line line : lines) {
            currentIndex = line.movedPointIndex(currentIndex);
        }
        return currentIndex;
    }

    @Override
    public String toString() {
        return "Lines{" +
                "lines=" + lines +
                '}';
    }
}

package nextstep.ladder.model;

import nextstep.common.Assert;

import java.util.ArrayList;
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
}

package cc.oakk.ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import cc.oakk.ladder.model.line.Line;
import cc.oakk.ladder.model.size.LadderHeight;
import cc.oakk.ladder.model.size.LadderWidth;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int width, int height) {
        new LadderWidth(width);
        new LadderHeight(height);
        this.lines = Collections.unmodifiableList(IntStream.range(0, height).boxed()
                            .map(dummy -> new Line(width))
                            .collect(Collectors.toList()));
    }

    public List<Line> getLines() {
        return lines;
    }

    public Ladder initLines(Function<Integer, int[]> eval) {
        lines.forEach(line -> line.connect(eval.apply(line.width())));
        return this;
    }
}

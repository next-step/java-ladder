package cc.oakk.ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import cc.oakk.ladder.model.line.Line;
import cc.oakk.ladder.model.line.MutableLine;
import cc.oakk.ladder.model.size.LadderSize;

public class Ladder {
    private final LadderSize size;
    private final List<MutableLine> lines;

    public Ladder(int width, int height) {
        this.size = new LadderSize(width, height);
        this.lines = Collections.unmodifiableList(IntStream.range(0, size.height().get()).boxed()
                            .map(v -> new MutableLine(size.width().get()))
                            .collect(Collectors.toList()));
    }

    public List<Line> getLines() {
        return lines.stream()
                .map(v -> (Line) v)
                .collect(Collectors.toList());
    }

    public Ladder initLines(Function<Integer, int[]> eval) {
        lines.forEach(l -> l.connect(eval.apply(l.width())));
        return this;
    }
}

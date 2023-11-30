package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {
    private final List<Step> line;

    private Line(List<Step> line) {
        this.line = line;
    }

    public static Line from(int count) {
        List<Step> collect = IntStream.range(0, count)
            .mapToObj(i -> new Step())
            .collect(Collectors.toList());
        lineNeverOverlap(collect);
        return new Line(collect);
    }

    private static void lineNeverOverlap(List<Step> collect) {
        for (int i = 1; i < collect.size(); i++) {
            collect.set(i, collect.get(i).overlapStepReplace(collect.get(i - 1)));
        }
    }

    public int lineSize() {
        return line.size();
    }

    public void updateFirsLineToFalse() {
        List<Step> currentLine = this.line;
        if (currentLine != null && !currentLine.isEmpty()) {
            currentLine.set(0, Step.emptyStep());
        }
    }

    public Stream<Step> line() {
        return this.line.stream();
    }
}

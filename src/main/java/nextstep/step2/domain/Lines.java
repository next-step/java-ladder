package nextstep.step2.domain;

import nextstep.step2.generator.RandomBooleanGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private final List<Line> lines;

    public Lines(int count, int ladderHeight) {
        lines = IntStream.range(0, ladderHeight)
                .mapToObj(i -> createLine(count))
                .collect(Collectors.toList());
    }

    private Line createLine(int count) {
        return new Line(count, new RandomBooleanGenerator());
    }

    public List<Line> lines() {
        return lines;
    }

    public int size() {
        return this.lines.size();
    }
}

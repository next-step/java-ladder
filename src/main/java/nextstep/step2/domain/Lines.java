package nextstep.step2.domain;

import nextstep.step2.generator.RandomBooleanGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private List<Line> lines;

    public Lines(int count, int ladderHeight) {
        lines = IntStream.range(0, ladderHeight)
                .mapToObj(i -> createLine(count))
                .collect(Collectors.toList());
    }

    public Lines(Line... lines) {
        this.lines = Arrays.asList(lines);
    }

    private Line createLine(int count) {
        return new Line(count, new RandomBooleanGenerator());
    }

    public String drawLines() {
        return lines.stream()
                .map(Line::drawLine)
                .collect(Collectors.joining("\n"));
    }

    public int size() {
        return this.lines.size();
    }
}

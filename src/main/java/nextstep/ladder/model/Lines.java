package nextstep.ladder.model;

import nextstep.ladder.factory.LineFactory;
import nextstep.ladder.generator.LineRandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines = new ArrayList<>();
    private final LineRandomGenerator generator = new LineRandomGenerator();

    public Lines(int width, int height) {
        IntStream.range(0, height).forEach(index -> lines.add(LineFactory.of(width, generator)));
    }

    @Override
    public String toString() {
        return lines.stream()
                .map(Line::toString)
                .collect(Collectors.joining("\n"));
    }
}

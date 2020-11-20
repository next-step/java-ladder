package ladder.domain;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, Supplier<Line> supplier) {
        lines = IntStream.range(0, height)
                .mapToObj(i -> supplier.get())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return lines.stream()
                .map(line -> System.lineSeparator() + line)
                .reduce("", String::concat);
    }
}

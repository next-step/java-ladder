package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public static Ladder init(int countOfLines, int height) {
        return new Ladder(
                IntStream.range(0, countOfLines)
                        .mapToObj(i -> Line.init(height))
                        .collect(Collectors.toList())
        );
    }

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public void create(int height) {
        lines.stream()
                .reduce(Line.init(height), (prevLine, nextLine) -> {
                    nextLine.create(prevLine);
                    return nextLine;
                });
    }

    public List<Line> lines() {
        return lines;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }
}

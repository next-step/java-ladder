package ladder.domain;

import ladder.domain.util.LineGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    public static final int START_INCLUSIVE = 0;
    public static final String LINE_BREAK = "\n";
    public static final String SPACE = " ";
    private final List<Line> lines;

    public Lines(Players players, int verticalLadderSize, LineGenerator generator) {
        this(generateLines(players.size(), verticalLadderSize, generator));
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }



    private static List<Line> generateLines(int playersSize, int verticalLadderSize, LineGenerator generator) {
        return IntStream.range(START_INCLUSIVE, verticalLadderSize)
                .boxed()
                .map(index -> new Line(playersSize, generator))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}

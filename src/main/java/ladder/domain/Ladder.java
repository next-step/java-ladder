package ladder.domain;

import ladder.domain.util.HorizontalGenerator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    public static final int START = 0;
    private final List<Line> lines;
    private final Players players;

    public Ladder(Players players, int verticalLadderSize, HorizontalGenerator generator) {
        this(players, IntStream.range(START, verticalLadderSize)
                .boxed()
                .map(index -> new Line(players.size(), generator))
                .collect(Collectors.toList())
        );
    }

    public Ladder(Players players, List<Line> lines) {
        this.players = players;
        this.lines = lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    public String toLadderString() {
        return lines.stream()
                .map(line -> line.toLineString(players.names()))
                .collect(Collectors.joining("\n"));
//        return new StringBuilder()
//                .append("    |-----|     |-----|")
//                .append("    |-----|     |-----|")
//                .append("    |-----|     |-----|")
//                .append("    |-----|     |-----|")
//                .append("    |-----|     |-----|")
//                .toString();
    }
}

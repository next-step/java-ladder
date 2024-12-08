package ladder.domain.ns;

import ladder.domain.engine.Line;
import ladder.domain.engine.Lines;
import ladder.domain.engine.Players;
import ladder.domain.engine.generator.CrossGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NsLines implements Lines {
    public static final int START_INCLUSIVE = 0;
    private final List<Line> lines;

    public NsLines(Players players, int verticalLadderSize, CrossGenerator generator) {
        this(generateLines(players.size(), verticalLadderSize, generator));
    }

    public NsLines(List<Line> lines) {
        this.lines = lines;
    }

    private static List<Line> generateLines(int playersSize, int verticalLadderSize, CrossGenerator generator) {
        return IntStream.range(START_INCLUSIVE, verticalLadderSize)
                .boxed()
                .map(index -> new NsLine(playersSize, generator))
                .collect(Collectors.toList());
    }

    @Override
    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    @Override
    public Players move(Players players) {
        for (Line line : lines) {
            players = line.move(players);
        }
        return players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NsLines lines1 = (NsLines) o;
        return Objects.equals(lines, lines1.lines);
    }
    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}

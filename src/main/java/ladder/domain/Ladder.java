package ladder.domain;

import ladder.domain.line.ILine;
import ladder.domain.line.LineFactory;
import ladder.domain.player.Players;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Ladder {
    private final List<ILine> lines;

    public Ladder(int playerCount, int height, LineFactory lineFactory) {
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> lineFactory.create(playerCount))
                .collect(toList());
    }

    Ladder(List<ILine> lines) {
        this.lines = lines;
    }

    public List<ILine> lines() {
        return lines;
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
        return lines != null ? lines.hashCode() : 0;
    }

    public Players goDown(Players players) {
        Players result = players;
        for (ILine line: lines) {
            result = result.move(line);
        }
        return result;
    }
}

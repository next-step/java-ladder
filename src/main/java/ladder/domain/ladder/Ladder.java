package ladder.domain.ladder;

import ladder.domain.user.Players;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public static Ladder createLadder(Players players, Height height) {
        List<Line> lines = range(0, height.getHeight())
                .mapToObj(i -> new Line(players.size(), new RandomLadder()))
                .collect(toList());
        return new Ladder(lines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }

}





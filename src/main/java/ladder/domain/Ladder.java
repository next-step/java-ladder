package ladder.domain;

import ladder.domain.strategy.GeneratorInterface;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int move(int position) {
        int current = position;
        for (Line line : lines) {
            current = line.move(current);
        }

        return current;
    }

    public static final Ladder of(int numOfHeight, int numOfUsers, GeneratorInterface strategy) {
        List<Line> lines = IntStream.range(0, numOfHeight)
                .mapToObj(i -> Line.create(numOfUsers, strategy))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    public LadderResult getResult() {
        Map<Integer, Integer> map = new HashMap<>();
        IntStream.range(0, lines.size())
                .forEach(i -> map.put(i, move(i)));

        return new LadderResult(map);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder1 = (Ladder) o;
        return Objects.equals(lines, ladder1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}

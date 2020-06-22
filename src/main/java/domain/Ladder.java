package domain;

import generator.RandomPointGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int countOfPlayer, int height) {
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> Line.of(countOfPlayer, new RandomPointGenerator()))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }
}

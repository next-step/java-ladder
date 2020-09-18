package laddergame.domain.ladder;

import laddergame.domain.line.Line;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private List<Line> lines;
    private Random random = new Random();

    public Ladder(int maxHeight, int playsCount) {
        lines = Stream.generate(() -> new Line(playsCount - 1, () -> random.nextBoolean()))
                .limit(maxHeight)
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }
}
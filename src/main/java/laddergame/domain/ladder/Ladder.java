package laddergame.domain.ladder;

import laddergame.domain.line.Line;
import laddergame.domain.utils.Constants;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private List<Line> lines;
    private Random random = new Random();

    public Ladder(int maxHeight, int playsCount) {
        lines = Stream.generate(() -> new Line(Constants.LADDER_VERTICAL_COUNT(playsCount), () -> random.nextBoolean()))
                .limit(maxHeight)
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }
}
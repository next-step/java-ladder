package ladder.model.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, int countOfPlayers) {
        lines = new ArrayList<>();
        IntStream.range(0, height)
                .forEach(i -> lines.add(new Line(countOfPlayers)));
    }

    public List<Line> getLines() {
        return lines;
    }
}

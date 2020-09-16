package laddergame.domain.ladder;

import laddergame.domain.line.Line;
import laddergame.domain.utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Ladder {

    private List<Line> lines;

    public Ladder(int maxHeight, int playsCount) {
        lines = new ArrayList<>();

        Random random = new Random();
        IntStream.rangeClosed(Constants.COUNT_ONE, maxHeight)
                .forEach(i -> lines.add(new Line(playsCount - Constants.COUNT_ONE, () -> random.nextInt(Constants.LADDER_CONNECTION_MAX_COUNT) >= Constants.LADDER_CONNECTION_PROBABILITY)));
    }

    public List<Line> getLines() {
        return lines;
    }
}

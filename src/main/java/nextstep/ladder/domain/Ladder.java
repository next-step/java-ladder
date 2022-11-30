package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    private final HashMap<Integer, Integer> result;

    public Ladder(Line line) {
        this(Arrays.asList(line));
    }

    public Ladder(List<Line> lines) {
        this.result = new HashMap<>();
        this.lines = lines;
    }

    public List<Line> ladder() {
        return lines;
    }

    public void move(int numberOfPlayer) {
        for (int startPosition = 0; startPosition < numberOfPlayer; startPosition++) {
            result.put(startPosition, moveLine(startPosition));
        }
    }

    public HashMap<Integer, Integer> result() {
        return result;
    }

    private int moveLine(int startPosition) {
        int destination = startPosition;
        for (Line line : lines) {
            destination = line.move(destination);
        }
        return destination;

    }
}

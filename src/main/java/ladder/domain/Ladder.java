package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final static int INITIAL = 0;
    private final int countOfPerson;
    private final List<Line> lines;

    public Ladder(int height, int countOfPerson) {
        lines = new ArrayList<>();
        this.countOfPerson = countOfPerson;
        Strategy strategy = new DeduplicationStrategy();
        IntStream.range(INITIAL, height)
                .forEachOrdered(number -> lines.add(new Line(countOfPerson, strategy)));

    }

    public Ladder(List<Line> lines) {
        this.countOfPerson = lines.size();
        this.lines = new ArrayList<>(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Integer> resultIndexes() {
        List<Integer> result = new ArrayList<>();
        IntStream.range(INITIAL, countOfPerson)
                .forEachOrdered(index -> result.add(move(index)));
        return result;
    }

    public int move(int index) {
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
    }
}

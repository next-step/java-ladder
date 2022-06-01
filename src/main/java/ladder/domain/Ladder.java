package ladder.domain;

import java.util.*;
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

    public Ladder(List<Line> lines, int countOfPerson) {
        this.countOfPerson = countOfPerson;
        this.lines = new ArrayList<>(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<String> moveAll(List<String> results) {
        List<String> finalResult = new ArrayList<>();
        IntStream.range(INITIAL, countOfPerson)
                .forEachOrdered(index -> finalResult.add(results.get(moveOne(index))));
        return finalResult;
    }

    private int moveOne(int index) {
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
    }
}

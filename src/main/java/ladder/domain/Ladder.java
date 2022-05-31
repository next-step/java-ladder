package ladder.domain;

import java.util.*;
import java.util.stream.IntStream;

public class Ladder {
    private final static int INITIAL = 0;
    private final List<Line> lines;

    private Ladder(int height, int countOfPerson) {
        lines = new ArrayList<>();
        IntStream.range(INITIAL, height)
                .forEachOrdered(number -> lines.add(Line.of(new DeduplicationStrategy(), countOfPerson)));
    }

    public Ladder(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public static Ladder of(int height, int numberOfUser) {
        return new Ladder(height, numberOfUser);
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Integer> extractIndexes(int countOfPerson) {
        List<Integer> resultIndexes = new ArrayList<>();

        IntStream.range(INITIAL, countOfPerson).forEachOrdered(number -> {
            number = move(number);
            resultIndexes.add(number);
        });
        return resultIndexes;
    }

    private int move(int index) {
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(getLines(), ladder.getLines());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLines());
    }
}

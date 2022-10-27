package laddergame.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {


    private final List<Line> lines;


    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int countOfLadder, int numberOfPeople) {
        List<Line> lines = IntStream.range(0, countOfLadder)
                .mapToObj(__ -> Line.of(numberOfPeople))
                .collect(Collectors.toUnmodifiableList());
        return new Ladder(lines);
    }


    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int findRewardIndex(int index) {
        for (Line line : lines) {
            index = line.nextIndex(index);
        }
        return index;
    }

}

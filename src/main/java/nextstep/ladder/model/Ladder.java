package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int ladderHeight, int countOfPerson, Random random) {
        this.lines = new ArrayList<>();
        IntStream.range(0, ladderHeight)
            .mapToObj(line -> new Line(countOfPerson, random))
            .forEach(this.lines::add);
    }

    public List<Line> getLines() {
        return lines;
    }
}

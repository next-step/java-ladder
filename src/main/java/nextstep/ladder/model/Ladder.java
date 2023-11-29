package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(LadderHeight heightOfLadder, PersonCount countOfPerson, Random random) {
        this.lines = new ArrayList<>();
        IntStream.range(0, heightOfLadder.getHeightOfLadder())
            .mapToObj(line -> new Line(countOfPerson.getCountOfPerson(), random))
            .forEach(this.lines::add);
    }

    public List<Line> getLines() {
        return lines;
    }
}

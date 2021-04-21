package step2.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int height, int countOfPerson, LineStrategy lineStrategy) {
        createLadder(height, countOfPerson, lineStrategy);
    }

    public List<Line> value() {
        return this.ladder;
    }

    private void createLadder(int height, int countOfPerson, LineStrategy lineStrategy) {
        IntStream.range(0, height)
            .forEach(ignore -> ladder.add(new Line(countOfPerson, lineStrategy)));
    }
}

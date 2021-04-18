package step2.domain;

import static step2.view.ViewConstants.NEW_LINE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int height, int countOfPerson, LineStrategy lineStrategy) {
        createLadder(height, countOfPerson, lineStrategy);
    }

    private void createLadder(int height, int countOfPerson, LineStrategy lineStrategy) {
        IntStream.range(0, height)
            .forEach(ignore -> ladder.add(new Line(countOfPerson, lineStrategy)));
    }

    @Override
    public String toString() {
        return ladder.stream()
            .map(Line::toString)
            .collect(Collectors.joining(NEW_LINE));
    }
}

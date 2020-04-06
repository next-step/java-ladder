package ladder;

import java.util.Arrays;
import java.util.List;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(int countOfPerson, int ladderMaxHeight) {
        ladder = generate();
    }

    private List<Line> generate() {
        return Arrays.asList(
                new Line(4),
                new Line(4),
                new Line(4),
                new Line(4),
                new Line(4));
    }

    public int getWidth() {
        return ladder.stream()
                .findAny()
                .get()
                .getWidth();
    }

    public int getHeight() {
        return ladder.size();
    }
}

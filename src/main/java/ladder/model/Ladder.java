package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final List<Line> ladder;
    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder makeLadder(int height, int countOfPerson) {
        List<Line> ladder = new ArrayList<>();
        LineStrategy lineStrategy = new LineStrategyRamdom();

        for (int i = 0; i < height; i++) {
            ladder.add(new Line(countOfPerson, lineStrategy));
        }

        return new Ladder(ladder);
    }

    public List<Line> getLadder() {
        return this.ladder;
    }

}

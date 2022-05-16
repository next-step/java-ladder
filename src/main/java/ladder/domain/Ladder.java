package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<HorizontalLines> ladder;

    public Ladder() {
        this(new ArrayList<>());
    }

    public Ladder(List<HorizontalLines> ladder) {
        this.ladder = ladder;
    }

    public List<HorizontalLines> create(int countOfPerson, int numberOfMoves) {
        for (int index = 0; index < numberOfMoves; index++) {
            HorizontalLines horizontalLines = new HorizontalLines();
            horizontalLines.connect(countOfPerson - 1);
            ladder.add(horizontalLines);
        }
        return ladder;
    }
}

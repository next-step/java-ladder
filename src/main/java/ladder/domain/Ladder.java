package ladder.domain;

import ladder.domain.exception.InvalidLadderHeightException;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static int LADDER_HEIGHT_MIN = 1;

    private final List<Line> ladder;

    private Ladder(int height, int countOfPerson) {
        if (height < LADDER_HEIGHT_MIN) {
            throw new InvalidLadderHeightException();
        }

        this.ladder = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            ladder.add(new Line(countOfPerson));
        }
    }

    public static Ladder getInstance(int height, int countOfPerson) {
        return new Ladder(height, countOfPerson);
    }

    public int getHeight() {
        return this.ladder.size();
    }
}

package ladder.domain;

import ladder.domain.exception.InvalidLadderHeight;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static int LADDER_HEIGHT_MIN = 1;

    private final List<Line> ladder;

    private Ladder(int height) {
        if (height < LADDER_HEIGHT_MIN) {
            throw new InvalidLadderHeight();
        }

        this.ladder = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            ladder.add(new Line());
        }
    }

    public static Ladder getInstance(int height) {
        return new Ladder(height);
    }

    public int getHeight() {
        return this.ladder.size();
    }
}

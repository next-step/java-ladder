package ladder.domain;

import ladder.domain.line.Lines;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final List<Lines> ladder = new ArrayList<>();

    public static Ladder of(int height, int width) {
        return new Ladder(height, width);
    }

    private Ladder(int height, int width) {
        for (int i = 0; i < height; i++) {
            ladder.add(new Lines(width));
        }
    }

    public List<Lines> getLadder() {
        return ladder;
    }
}

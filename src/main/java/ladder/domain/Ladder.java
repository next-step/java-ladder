package ladder.domain;

import java.util.*;

public class Ladder {
    private Map<Height, Line> ladder;

    public Ladder(final int playerCount, final Height height) {
        this.ladder = createLines(playerCount, height);
    }

    private Map<Height, Line> createLines(final int playerCount, final Height height) {
        Map<Height, Line> ladder = new HashMap<>();
        for (int i = 0; i < height.value(); i++) {
            ladder.put(Height.of(i + 1), new Line(playerCount));
        }
        return Collections.unmodifiableMap(ladder);
    }
}

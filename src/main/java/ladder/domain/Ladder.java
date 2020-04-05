package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Ladder {
    private final Map<Height, Line> ladder;

    public Ladder(final int playerCount, final Height height) {
        this.ladder = createLines(playerCount, height);
    }

    public Map<Height, Line> getLadder() {
        return ladder;
    }

    private Map<Height, Line> createLines(final int playerCount, final Height height) {
        Map<Height, Line> ladder = new HashMap<>();
        for (int i = Height.MIN_HEIGHT; i <= height.value(); i++) {
            ladder.put(Height.of(i), new Line(playerCount));
        }
        return Collections.unmodifiableMap(ladder);
    }
}

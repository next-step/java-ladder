package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {
    private final int playerCount;

    public LineGenerator(final int playerCount) {
        this.playerCount = playerCount;
    }

    public List<Boolean> generate() {
        final List<Boolean> lines = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            lines.add(false);
        }
        return lines;
    }
}
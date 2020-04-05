package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {
    private final int playerCount;

    public LineGenerator(final int playerCount) {
        this.playerCount = playerCount;
    }

    public List<Boolean> generate() {
        final List<Boolean> lines = init();
        for (int i = lines.size(); i < playerCount; i++) {
            lines.add(false);
        }
        return lines;
    }

    private List<Boolean> init() {
        List<Boolean> lines = new ArrayList<>();
        lines.add(Boolean.FALSE);
        return lines;
    }
}
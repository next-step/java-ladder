package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineGenerator {
    private final Random random = new Random();
    private final int playerCount;

    public LineGenerator(final int playerCount) {
        this.playerCount = playerCount;
    }

    public List<Boolean> generate() {
        final List<Boolean> lines = init();
        for (int i = lines.size(); i < playerCount; i++) {
            boolean prevLine = lines.get(i - 1);
            lines.add(drawLine(prevLine));
        }
        return lines;
    }

    private List<Boolean> init() {
        List<Boolean> lines = new ArrayList<>();
        lines.add(Boolean.FALSE);
        return lines;
    }

    private Boolean drawLine(final boolean isExistPrev) {
        if (isExistPrev) {
            return Boolean.FALSE;
        }
        return random.nextBoolean();
    }
}
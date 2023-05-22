package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LadderRow {

    private List<Boolean> lines;
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public LadderRow(int width) {
        lines = generateLines(width);
    }

    private List<Boolean> generateLines(int width) {
        List<Boolean> newLines = new ArrayList<>();
        newLines.add(generateLine());
        for (int i = 1; i < width; i++) {
            newLines.add(generateLine(newLines.get(i - 1)));
        }

        return newLines;
    }

    private Boolean generateLine() {
        return RANDOM.nextBoolean();
    }

    private Boolean generateLine(boolean preValue) {
        if (preValue) {
            return false;
        }
        return RANDOM.nextBoolean();
    }

    public int size() {
        return lines.size();
    }
}

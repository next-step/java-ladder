package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomLineGenerator implements LineGenerator {
    private final static Random random = new Random();
    private final int lineQuantity;
    private final List<Boolean> lines;

    public RandomLineGenerator(int lineQuantity) {
        this.lineQuantity = lineQuantity;
        this.lines = new ArrayList<>();
        fillLines();
    }

    @Override
    public List<Boolean> getLineBase() {
        return Collections.unmodifiableList(lines);
    }

    private void fillLines() {
        lines.add(false);
        IntStream.range(0, lineQuantity - 1)
                .forEach(i -> lines.add(!hasTruePreviousIndex() && random.nextBoolean()));
    }

    private boolean hasTruePreviousIndex() {
        return lines.get(lines.size() - 1);
    }
}

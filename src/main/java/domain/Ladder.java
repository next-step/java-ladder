package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
public class Ladder {

    private static final Random RANDOM = new Random();

    private final List<LadderRow> ladderRows = new ArrayList<>();

    public Ladder(int height, int width) {
        for (int i = 0; i < height; i++) {
            ladderRows.add(new LadderRow(width, () -> RANDOM.nextBoolean()));
        }
    }

    public void forEach(Consumer<LadderRow> consumer) {
        ladderRows.forEach(consumer);
    }
}

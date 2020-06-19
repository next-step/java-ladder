package nextstep.ladder.domain;

import java.util.*;

public class RandomLadderGenerator implements LadderGenerator {
    private static final Random RAND = new Random();
    private static final List<Boolean> HOLDER_LIST = Arrays.asList(true, false);
    private static final boolean FIRST_HOLDER = false;
    private static final int X_OFFSET = 1;
    private static final int Y_OFFSET = 0;

    private final int width;
    private final int height;

    public RandomLadderGenerator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public List<Line> generate() {
        List<Line> lines = new ArrayList<>();

        for (int i = Y_OFFSET; i < height; i++) {
            lines.add(getNextLine());
        }
        return lines;
    }

    private Line getNextLine() {
        List<Boolean> holders = new ArrayList<>();
        boolean exHolder = FIRST_HOLDER;

        holders.add(exHolder);
        for (int i = X_OFFSET; i < width; i++) {
            boolean nextHolder = getNextHolder(exHolder);
            exHolder = nextHolder;
            holders.add(nextHolder);
        }
        return new Line(holders);
    }

    private boolean getNextHolder(boolean exHolder) {
        if (exHolder) {
            return false;
        }
        return HOLDER_LIST.get(RAND.nextInt(2));
    }
}

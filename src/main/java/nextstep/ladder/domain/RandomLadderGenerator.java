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
    public List<List<Boolean>> generate() {
        List<List<Boolean>> ladder2DList = new ArrayList<>();

        for (int i = Y_OFFSET; i < height; i++) {
            ladder2DList.add(getNextLine(width));
        }
        return ladder2DList;
    }

    private List<Boolean> getNextLine(int width) {
        List<Boolean> ladderList = new ArrayList<>();
        boolean exHolder = FIRST_HOLDER;

        ladderList.add(exHolder);
        for (int i = X_OFFSET; i < width; i++) {
            boolean nextHolder = getNextHolder(exHolder);
            exHolder = nextHolder;
            ladderList.add(nextHolder);
        }
        return ladderList;
    }

    private boolean getNextHolder(boolean exHolder) {
        if (exHolder) {
            return false;
        }
        return HOLDER_LIST.get(RAND.nextInt(2));
    }
}

package ladder.domain.ladderMap;

import java.util.Random;

public class Link {

    private static final int EMPTY = -1;
    private static final int POSSIBILITIES = 2;
    private static final int ACTIVE = 1;

    private static Random random = new Random();
    private static int lastLinkIndex = EMPTY;

    private final int from;
    private final int to;

    public Link(int fromIndex) {
        this.from = randomIfValid(fromIndex);
        this.to = fromPlusOneIfValid();
    }

    public static void init() {
        lastLinkIndex = EMPTY;
    }

    private int randomIfValid(int fromIndex) {
        if (fromIndex == lastLinkIndex || random.nextInt(POSSIBILITIES) != ACTIVE) {
            return EMPTY;
        }
        lastLinkIndex = fromIndex + 1;
        return fromIndex;
    }

    private int fromPlusOneIfValid() {
        if (lastLinkIndex == this.from) {
            return lastLinkIndex;
        }
        return EMPTY;
    }

    public boolean empty() {
        return this.from != EMPTY;
    }
}

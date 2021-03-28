package ladder.domain.ladderMap;

import ladder.exception.CustomException;
import ladder.exception.ErrorCode;

import java.util.Random;

public class Link {

    private static final int EMPTY = -1;
    private static final int POSSIBILITIES = 2;
    private static final int ACTIVE = 1;

    private static final Random random = new Random();
    private static int lastLinkIndex = EMPTY;

    private final int from;

    public Link(int fromIndex) {
        if (!valid(fromIndex)) {
            throw new CustomException(ErrorCode.INVALID_LINK_INDEX);
        }
        this.from = randomIfValid(fromIndex);
    }

    private boolean valid(int fromIndex) {
        return fromIndex >= 0;
    }

    public static void init() {
        lastLinkIndex = EMPTY;
    }

    private int randomIfValid(int fromIndex) {
        if (fromIndex == lastLinkIndex || random.nextInt(POSSIBILITIES) != ACTIVE) {
            return EMPTY;
        }
        Link.lastLinkIndex = fromIndex + 1;
        return fromIndex;
    }

    public boolean empty() {
        return this.from == EMPTY;
    }

    public int from() {
        return from;
    }

}

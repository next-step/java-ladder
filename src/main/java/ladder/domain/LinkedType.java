package ladder.domain;

import java.util.Random;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public enum LinkedType {
    ONLY_LEFT_LINKED(TRUE, FALSE),
    ONLY_RIGHT_LINKED(FALSE, TRUE),
    NEITHER_LINKED(FALSE, FALSE);

    private final boolean leftLink;
    private final boolean rightLink;

    LinkedType(boolean leftLink, boolean rightLink) {
        this.leftLink = leftLink;
        this.rightLink = rightLink;
    }

    public static LinkedType first() {
        return new Random().nextBoolean() ? ONLY_RIGHT_LINKED : NEITHER_LINKED;
    }

    public LinkedType last() {
        return this.rightLink ? ONLY_LEFT_LINKED : NEITHER_LINKED;
    }

    public LinkedType next() {
        if (this.isRightLinked()) {
            return ONLY_LEFT_LINKED;
        }
        return new Random().nextBoolean() ? ONLY_RIGHT_LINKED : NEITHER_LINKED;
    }

    public boolean isLeftLinked() {
        return leftLink;
    }

    public boolean isRightLinked() {
        return rightLink;
    }
}

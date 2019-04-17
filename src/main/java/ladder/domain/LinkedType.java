package ladder.domain;

import ladder.domain.generator.ValueGenerator;

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

    public static LinkedType first(Boolean value) {
        return value ? ONLY_RIGHT_LINKED : NEITHER_LINKED;
    }

    public LinkedType last() {
        return this.rightLink ? ONLY_LEFT_LINKED : NEITHER_LINKED;
    }

    public LinkedType next(Boolean value) {
        if (this.isRightLinked()) {
            return ONLY_LEFT_LINKED;
        }
        return value ? ONLY_RIGHT_LINKED : NEITHER_LINKED;
    }

    public boolean isLeftLinked() {
        return leftLink;
    }

    public boolean isRightLinked() {
        return rightLink;
    }
}

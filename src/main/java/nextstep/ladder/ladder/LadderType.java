package nextstep.ladder.ladder;

import nextstep.ladder.exception.NotFoundLadderTypeException;

import java.util.Arrays;

public enum LadderType {

    TRUE(true, "-----"),
    FALSE(false, "     ");

    private final boolean creatable;
    private final String ladder;

    LadderType(boolean creatable, String ladder) {
        this.creatable = creatable;
        this.ladder = ladder;
    }

    public static LadderType findByType(boolean type) {
        return Arrays.stream(values())
                .filter(t -> t.creatable == type)
                .findFirst()
                .orElseThrow(NotFoundLadderTypeException::new);
    }

    public String getLadder() {
        return ladder;
    }
}

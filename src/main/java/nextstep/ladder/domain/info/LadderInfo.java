package nextstep.ladder.domain.info;

import java.util.Objects;

public class LadderInfo {
    private final LadderSize ladderSize;

    private LadderInfo(LadderSize ladderSize) {
        validate(ladderSize);

        this.ladderSize = ladderSize;
    }

    private void validate(LadderSize ladderSize) {
        if (Objects.isNull(ladderSize)) {
            throw new IllegalArgumentException("LadderSize는 null이면 안된다");
        }
    }

    public static LadderInfo of(LadderSize ladderSize) {
        return new LadderInfo(ladderSize);
    }
}

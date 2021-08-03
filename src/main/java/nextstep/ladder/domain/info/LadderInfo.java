package nextstep.ladder.domain.info;

import nextstep.ladder.domain.strategy.LineCreateStrategy;

import java.util.Objects;

public class LadderInfo {
    private final LadderSize ladderSize;
    private final LineCreateStrategy lineCreateStrategy;

    private LadderInfo(LadderSize ladderSize, LineCreateStrategy lineCreateStrategy) {
        validate(ladderSize, lineCreateStrategy);

        this.ladderSize = ladderSize;
        this.lineCreateStrategy = lineCreateStrategy;
    }

    private void validate(LadderSize ladderSize, LineCreateStrategy lineCreateStrategy) {
        if (Objects.isNull(ladderSize)) {
            throw new IllegalArgumentException("LadderSize는 null이면 안된다");
        }

        if (Objects.isNull(lineCreateStrategy)) {
            throw new IllegalArgumentException("LineCreateStrategy는 null이면 안된다");
        }
    }

    public static LadderInfo of(LadderSize ladderSize, LineCreateStrategy lineCreateStrategy) {
        return new LadderInfo(ladderSize, lineCreateStrategy);
    }

    public int getLadderWidth() {
        return ladderSize.getWidth();
    }

    public int getLadderHeight() {
        return ladderSize.getHeight();
    }

    public LineCreateStrategy getLineCreateStrategy() {
        return lineCreateStrategy;
    }

    public boolean isMinWidthSize() {
        return ladderSize.isMinWidth();
    }
}

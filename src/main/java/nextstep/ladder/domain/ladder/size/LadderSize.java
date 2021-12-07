package nextstep.ladder.domain.ladder.size;

import static nextstep.ladder.utils.Validation.checkNotNull;

public class LadderSize {

    private final LadderWidth ladderWidth;
    private final LadderHeight ladderHeight;

    public LadderSize(LadderWidth ladderWidth, LadderHeight ladderHeight) {
        checkNotNull(ladderWidth, ladderHeight);
        this.ladderWidth = ladderWidth;
        this.ladderHeight = ladderHeight;
    }

    public int height() {
        return ladderHeight.getHeight();
    }

    public LadderWidth getLadderWidth() {
        return ladderWidth;
    }
}

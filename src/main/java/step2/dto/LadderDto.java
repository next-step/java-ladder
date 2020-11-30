package step2.dto;

import step2.domain.LineStrategy;

public class LadderDto {
    private final int ladderHeight ;
    private final LineStrategy lineStrategy;

    public LadderDto(int ladderHeight, LineStrategy lineStrategy) {
        this.ladderHeight = ladderHeight;
        this.lineStrategy = lineStrategy;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public LineStrategy getLineStrategy() {
        return lineStrategy;
    }
}

package nextstep.ladder.domain.line;

public class LadderConstructionStatus {

    private final boolean ladderConstructionStatus;

    public LadderConstructionStatus(boolean ladderConstructionStatus) {
        this.ladderConstructionStatus = ladderConstructionStatus;
    }

    public boolean isLadderConstructionStatusFalse() {
        return !ladderConstructionStatus;
    }

    public boolean isLadderConstructionStatus() {
        return ladderConstructionStatus;
    }
}

package ladder.domain.ladder.strategy;

public enum LadderConnectType {

    DISCONTINUOUS(new LadderDiscontinuousConnectStrategy());

    private final LadderConnectStrategy ladderConnectStrategy;

    LadderConnectType(LadderConnectStrategy ladderConnectStrategy) {
        this.ladderConnectStrategy = ladderConnectStrategy;
    }

    public LadderConnectStrategy strategy() {
        return this.ladderConnectStrategy;
    }
}

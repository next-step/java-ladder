package ladder.domain;

public interface BridgeLinesStrategy {

    BridgeLines create(final int amount, final LadderHeight height);
}

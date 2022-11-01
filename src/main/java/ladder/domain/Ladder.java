package ladder.domain;

import ladder.strategy.BridgeLinesStrategy;

public class Ladder {

    private final Participants participants;
    private final LadderHeight height;
    private final BridgeLines bridgeLines;

    public Ladder(final Participants participants, final LadderHeight height, final BridgeLinesStrategy strategy) {
        this.participants = participants;
        this.height = height;
        this.bridgeLines = strategy.create(participants.size() - 1, height);
    }

    public Participants getParticipants() {
        return new Participants(participants);
    }

    public LadderHeight getHeight() {
        return this.height;
    }

    public BridgeLines getBridgeLines() {
        return bridgeLines;
    }

    public BridgeLine getBridgeLine(final int index) {
        return this.bridgeLines.getBridgeLines()
                               .get(index);
    }
}

package ladder.domain;

import ladder.strategy.BridgeLinesStrategy;

public class Ladder {

    private final Participants participants;
    private final LadderHeight height;
    private final BridgeLines bridgeLines;

    public Ladder(final Participants participants, final int height, final BridgeLinesStrategy strategy) {
        this(participants, new LadderHeight(height), strategy);
    }

    public Ladder(final Participants participants, final LadderHeight height, final BridgeLinesStrategy strategy) {
        this.participants = participants;
        this.height = height;
        this.bridgeLines = strategy.create(participants.size(), height);
    }

    public Participants getParticipants() {
        return new Participants(participants);
    }

    public LadderHeight getHeight() {
        return this.height;
    }
}

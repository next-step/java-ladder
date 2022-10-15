package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGameResult {

    private final List<ParticipantName> participantNames;
    private final List<LadderLineConnections> connectionsByHeight;

    public LadderGameResult(List<ParticipantName> participantNames, List<LadderLineConnections> connectionsByHeight) {
        this.participantNames = participantNames;
        this.connectionsByHeight = connectionsByHeight;
    }

    public static LadderGameResult of(List<ParticipantName> participantNames, LadderHeight height) {
        List<LadderLineConnections> connectionsByHeight = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            connectionsByHeight.add(LadderLineConnections.from(participantNames.size() - 1));
        }
        return new LadderGameResult(participantNames, connectionsByHeight);
    }

    public List<ParticipantName> getParticipantNames() {
        return participantNames;
    }

    public List<LadderLineConnections> getConnectionsByHeight() {
        return connectionsByHeight;
    }

}

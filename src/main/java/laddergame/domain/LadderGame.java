package laddergame.domain;

import java.util.List;

public class LadderGame {

    public LadderGameResult run(List<ParticipantName> participantNames, LadderHeight height) {
        Ladder ladder = new Ladder(participantNames.size());
        for (int i = 0; i < height.getValue(); i++) {
            ladder.addLine();
        }
        return new LadderGameResult(participantNames, ladder);
    }

}

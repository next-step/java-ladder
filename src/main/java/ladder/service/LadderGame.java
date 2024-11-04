package ladder.service;

import ladder.domain.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {
    private static final int MIN_LADDER_COUNT = 2;

    public LadderGame() {
    }

    public Ladder createLadder(LadderSetting setting, ConnectionStrategy strategy) {
        if(setting.getLadderCount() < MIN_LADDER_COUNT) {
            throw new RuntimeException("사다리의 개수는 최소 2개 이상이어야 합니다.");
        }

        Ladder ladder = new Ladder();
        return ladder.createSteps(setting, strategy);
    }

    public LadderResult playGame(Ladder ladder, LadderGameData gameData) {
        return ladder.findOutcomeForParticipant(gameData);
    }


    public String getOutcomeForParticipant(LadderResult ladderResult, String participantNameForOutcome) {
        return ladderResult.getOutcomeForParticipant(participantNameForOutcome);
    }
}

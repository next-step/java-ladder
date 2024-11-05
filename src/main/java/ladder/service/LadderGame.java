package ladder.service;

import ladder.domain.ConnectionStrategy;
import ladder.domain.Ladder;
import ladder.domain.LadderGameData;
import ladder.domain.LadderResult;
import ladder.domain.LadderSetting;

public class LadderGame {
    private static final int MIN_LADDER_COUNT = 2;

    private LadderGame() {
    }

    public static Ladder createLadder(LadderSetting setting, ConnectionStrategy strategy) {
        if(setting.getLadderCount() < MIN_LADDER_COUNT) {
            throw new RuntimeException("사다리의 개수는 최소 2개 이상이어야 합니다.");
        }

        return Ladder.createSteps(setting, strategy);
    }

    public static LadderResult playGame(Ladder ladder, LadderGameData gameData) {
        return ladder.findOutcomeForParticipant(gameData);
    }


    public static String getOutcomeForParticipant(LadderResult ladderResult, String participantNameForOutcome) {
        return ladderResult.getOutcomeForParticipant(participantNameForOutcome);
    }
}

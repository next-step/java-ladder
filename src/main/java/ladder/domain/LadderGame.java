package ladder.domain;

import ladder.dto.GameInfo;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {
    private static final int RULE_LADDER_HEIGHT_MIN_COUNT = 1;

    private Ladder ladder;
    private LadderGameResult ladderGameResult;

    public LadderGame(GameInfo gameInfo, int ladderHeight) {
        validate(ladderHeight);
        this.ladder = new Ladder(gameInfo.getPlayers(), ladderHeight);
        this.ladderGameResult = playGame(gameInfo.getPlayers(), gameInfo.getPrizes());
    }

    public Ladder getLadder() {
        return this.ladder;
    }

    public LadderGameResult getLadderGameResult(){
        return this.ladderGameResult;
    }

    private LadderGameResult playGame(Players players, Prizes prizes) {
        MatchedLineInfos matchedLineInfos = ladder.getMatchedInfos();
        Map<String, String> ladderGameResult = new LinkedHashMap<>();
        for (int i = 1; i <= players.count(); i++) {
            ladderGameResult.put(players.getName(i - 1), prizes.getPrize(matchedLineInfos.getMatchedLineNo(i) - 1));
        }
        return new LadderGameResult(ladderGameResult);
    }

    private void validate(int ladderHeight) {
        if (ladderHeight < RULE_LADDER_HEIGHT_MIN_COUNT) {
            throw new IllegalArgumentException(String.format("사다리 높이는 %d 이상이어야 합니다.", RULE_LADDER_HEIGHT_MIN_COUNT));
        }
    }
}

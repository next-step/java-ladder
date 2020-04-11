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
        this.ladderGameResult = playGame(gameInfo.getPlayers(), gameInfo.getPlayResults());
    }

    public Ladder getLadder() {
        return this.ladder;
    }

    public LadderGameResult getLadderGameResult(){
        return this.ladderGameResult;
    }

    private LadderGameResult playGame(Players players, PlayResults playResults) {
        MatchedLineInfos matchedLineInfos = ladder.getMatchedInfos();
        Map<String, String> ladderGameResult = new LinkedHashMap<>();
        for (int i = 1; i <= players.getCount(); i++) {
            ladderGameResult.put(players.getPlayerName(i), playResults.getResult(matchedLineInfos.getMatchedLineNo(i)));
        }
        return new LadderGameResult(ladderGameResult);
    }

    private void validate(int ladderHeight) {
        if (ladderHeight < RULE_LADDER_HEIGHT_MIN_COUNT) {
            throw new IllegalArgumentException(String.format("사다리 높이는 %d 이상이어야 합니다.", RULE_LADDER_HEIGHT_MIN_COUNT));
        }
    }
}

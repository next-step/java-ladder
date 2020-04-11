package ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {
    private static final int RULE_PLAYER_MIN_COUNT = 2;
    private static final int RULE_PLAY_RESULT_MIN_COUNT = 2;
    private static final int RULE_LADDER_HEIGHT_MIN_COUNT = 1;

    private Ladder ladder;
    private LadderGameResult ladderGameResult;

    public LadderGame(Players players, PlayResults playResults, int ladderHeight) {
        validate(players, playResults, ladderHeight);
        this.ladder = new Ladder(players, ladderHeight);
        this.ladderGameResult = playGame(players, playResults);
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

    private void validate(Players players, PlayResults playResults, int ladderHeight) {
        validatePlayers(players);
        validatePlayResults(playResults);
        validateLadderHeight(ladderHeight);

        if (players.getCount() != playResults.getCount()) {
            throw new IllegalArgumentException("플레이어수와 결과개수는 일치해야 합니다.");
        }
    }

    private void validatePlayers(Players players) {
        if (players.getCount() < RULE_PLAYER_MIN_COUNT) {
            throw new IllegalArgumentException(String.format("플레이어는 %d명 이상이어야 합니다.", RULE_PLAYER_MIN_COUNT));
        }
    }

    private void validatePlayResults(PlayResults playResults) {
        if (playResults.getCount() < RULE_PLAY_RESULT_MIN_COUNT) {
            throw new IllegalArgumentException(String.format("게임 결과는 %d개 이상이어야 합니다.", RULE_PLAY_RESULT_MIN_COUNT));
        }
    }

    private void validateLadderHeight(int ladderHeight) {
        if (ladderHeight < RULE_LADDER_HEIGHT_MIN_COUNT) {
            throw new IllegalArgumentException(String.format("사다리 높이는 %d 이상이어야 합니다.", RULE_LADDER_HEIGHT_MIN_COUNT));
        }
    }
}

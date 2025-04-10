package ladder.domain;

import java.util.List;

public class LadderGameResults {
    private final List<LadderGameResult> ladderGameResults;

    public LadderGameResults(List<LadderGameResult> ladderGameResults) {
        this.ladderGameResults = ladderGameResults;
    }

    public Prize findPrizeByPlayerName(String playerName) {
        return ladderGameResults.stream()
                .filter(ladderGameResult -> ladderGameResult.hasPlayerName(playerName))
                .map(LadderGameResult::getPrize)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사다리 게임에 참가하지 않았습니다. 입력한 참가자 이름: " + playerName));
    }

    public List<LadderGameResult> getLadderGameResults() {
        return ladderGameResults;
    }
}

package ladder.model;

import java.util.List;

public class PlayerResults {
    private final List<PlayerResult> playerResults;

    PlayerResults(List<PlayerResult> playerResults) {
        this.playerResults = playerResults;
    }

    public String findLadderResult(String playerName) {
        return playerResults.stream()
                .filter(playerResult -> playerResult.matchPlayerName(playerName))
                .findFirst()
                .map(PlayerResult::getResult)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 플레이어 이름입니다."));
    }

    public List<PlayerResult> getPlayerResults() {
        return playerResults;
    }
}

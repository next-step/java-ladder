package ladder.domain;

import java.util.Map;
import java.util.Optional;

public class LadderGameResult {
    private final Map<Player, Prize> gameResult;

    public LadderGameResult(Map<Player, Prize> gameResult) {
        this.gameResult = gameResult;
    }

    public Prize findPrizeByPlayerName(String playerName) {
        Player player = new Player(playerName);
        return Optional.ofNullable(gameResult.get(player))
                .orElseThrow(() -> new IllegalArgumentException("사다리 게임에 참가하지 않았습니다. 입력한 참가자 이름: " + playerName));
    }

    public Map<Player, Prize> getGameResult() {
        return gameResult;
    }
}

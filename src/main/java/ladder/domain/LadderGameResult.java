package ladder.domain;

import java.util.Map;

public class LadderGameResult {
    private final Map<Player, Prize> gameResult;

    public LadderGameResult(Map<Player, Prize> gameResult) {
        this.gameResult = gameResult;
    }

    public Prize findPrizeByPlayerName(String playerName) {
        Prize prize = gameResult.get(new Player(playerName));
        if (prize == null) {
            throw new IllegalArgumentException("사다리 게임에 참가하지 않았습니다. 입력한 참가자 이름: " + playerName);
        }

        return prize;
    }

    public Map<Player, Prize> getGameResult() {
        return gameResult;
    }
}

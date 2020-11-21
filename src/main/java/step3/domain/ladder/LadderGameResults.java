package step3.domain.ladder;

import step3.domain.ladder.dto.PlayerWinningInfo;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class LadderGameResults {
    public static final String ERROR_NOT_FOUND_PLAYER = "존재하지 않는 플레이어입니다.";
    private final List<PlayerWinningInfo> playerWinningInfoList;

    public LadderGameResults(List<PlayerWinningInfo> playerWinningInfoList) {
        this.playerWinningInfoList = playerWinningInfoList;
    }

    public PlayerWinningInfo findResultByPlayer(Player player) {
        return playerWinningInfoList.stream()
                .filter(playerWinningInfo -> playerWinningInfo.match(player))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(ERROR_NOT_FOUND_PLAYER));
    }

    public void forEach(Consumer<PlayerWinningInfo> function) {
        playerWinningInfoList.forEach(function);
    }


}

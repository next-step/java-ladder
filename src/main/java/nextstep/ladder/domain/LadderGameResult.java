package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameResult {

    private final List<PlayerWinnings> playerWinnings;

    public LadderGameResult(PlayerWinnings playerWinnings) {
        this.playerWinnings = List.of(playerWinnings);
    }

    public LadderGameResult(List<PlayerWinnings> playerWinningsList) {
        this.playerWinnings = playerWinningsList;
    }

    @Override
    public String toString() {
        if (playerWinnings.size() == 1) {
            return playerWinnings.get(0).winningItemName();
        }

        return playerWinnings.stream().map(PlayerWinnings::toString).collect(Collectors.joining("\n"));
    }
}

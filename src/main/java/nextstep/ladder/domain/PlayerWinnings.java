package nextstep.ladder.domain;

import java.util.Objects;

public class PlayerWinnings {
    private final Player player;
    private final WinningItem winningItem;

    public PlayerWinnings(Player player, WinningItem winningItem) {
        nullCheck(player, winningItem);

        this.player = player;
        this.winningItem = winningItem;
    }

    public String winningItemName() {
        return winningItem.toString();
    }

    private void nullCheck(Player player, WinningItem winningItem) {
        if (Objects.isNull(player) || Objects.isNull(winningItem)) {
            throw new IllegalArgumentException("Player 또는 WinningItem 이 null 입니다.");
        }
    }

    @Override
    public String toString() {
        return player.toString() + ": " + winningItem.toString();
    }
}

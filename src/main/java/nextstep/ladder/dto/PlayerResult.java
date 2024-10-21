package nextstep.ladder.dto;

import nextstep.ladder.domain.Player;

import java.util.Objects;

public class PlayerResult {

    private final Player player;
    private final String result;

    public PlayerResult(Player player, String result) {
        this.player = player;
        this.result = result;
    }

    public String getPlayerName() {
        return player.getName();
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerResult that = (PlayerResult) o;
        return Objects.equals(player, that.player) && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, result);
    }
}

package nextstep.ladder.domain.player;

import java.util.Objects;

public class PlayerPrize {

    private final Player player;
    private final String prize;

    private PlayerPrize(Player player, String prize) {
        this.player = player;
        this.prize = prize;
    }

    public static PlayerPrize of(Player player, String prize) {
        return new PlayerPrize(player, prize);
    }

    public Player getPlayer() {
        return player;
    }

    public String getPrize() {
        return prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerPrize that = (PlayerPrize) o;
        return Objects.equals(player, that.player) &&
            Objects.equals(prize, that.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, prize);
    }
}

package nextstep.ladder.domain.player;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class PlayerPrizes {

    private final Map<Player, String> playerPrizes;

    public PlayerPrizes(Map<Player, String> playerPrizes) {
        this.playerPrizes = new LinkedHashMap<>(playerPrizes);
    }

    public Map<Player,String> getAll(){
        return new LinkedHashMap<>(playerPrizes);
    }

    public String get(Player player) {
        return playerPrizes.get(player);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerPrizes that = (PlayerPrizes) o;
        return Objects.equals(playerPrizes, that.playerPrizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerPrizes);
    }
}

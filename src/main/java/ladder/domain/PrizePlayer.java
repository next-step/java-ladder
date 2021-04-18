package ladder.domain;

import java.util.List;
import java.util.Objects;

public class PrizePlayer {
    private static final Player DEFAULT_PLAYER = new Player("");

    private final Players allPlayers;
    private final Player targetPlayer;

    public PrizePlayer(Players allPlayers) {
        this(allPlayers, DEFAULT_PLAYER);
    }

    public PrizePlayer(Players allPlayers, Player targetPlayer) {
        if (!targetPlayer.equals(DEFAULT_PLAYER) && allPlayers.index(targetPlayer) < 0) {
            throw new IllegalArgumentException("입력한 사람은 참가자에 없습니다.");
        }
        this.allPlayers = allPlayers;
        this.targetPlayer = targetPlayer;
    }

    public int index() {
        return allPlayers.index(targetPlayer);
    }

    public int indexOf(Player player) {
        return allPlayers.index(player);
    }

    public List<Player> allPlayers() {
        return allPlayers.allPlayers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrizePlayer that = (PrizePlayer) o;
        return Objects.equals(allPlayers, that.allPlayers) && Objects.equals(targetPlayer, that.targetPlayer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allPlayers, targetPlayer);
    }
}

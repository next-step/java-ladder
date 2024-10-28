package nextstep.ladder.v2.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PlayerGroup {
    private List<Player> players;

    public PlayerGroup(List<String> names) {
        this.players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getSize() {
        return players.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PlayerGroup)) {
            return false;
        }
        PlayerGroup that = (PlayerGroup) o;
        return Objects.equals(getPlayers(), that.getPlayers());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getPlayers());
    }
}

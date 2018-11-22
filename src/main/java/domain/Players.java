package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class Players {

    private final List<Player> players;

    public Players(final String player) {
        validation(player);
        final String[] values = player.split(",");
        this.players = Arrays.stream(values).map(Player::new).collect(toList());
    }

    public int calculatorPlayersLength() {
        return players.size() - 1;
    }

    private void validation(final String player) {
        Optional.ofNullable(player)
                .filter(p -> !"".equals(p))
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Players{");
        sb.append("players=").append(players);
        sb.append('}');
        return sb.toString();
    }

}

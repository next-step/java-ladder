package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Players {

    private final List<Player> players;

    public Players(final String player) {

        validation(player);
        final String[] values = player.split(",");
        this.players = Arrays.stream(values).map(Player::new).collect(toList());

        if (this.players.stream().distinct().count() != this.players.size()) {
            throw new IllegalArgumentException();
        }
    }

    public int size() {
        return players.size() - 1;
    }

    public Player findPlayerByIndex(final int index) {
        return players.get(index);
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
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < players.size(); i++) {
            if (i > 0) {
                sb.append("     ");
            }
            sb.append(players.get(i).toString());
        }
        return sb.toString();
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public int findByName(final String name) {
        return IntStream.range(0, this.players.size())
                .filter(i -> this.players.get(i).eqName(name))
                .findFirst()
                .getAsInt();
    }
}

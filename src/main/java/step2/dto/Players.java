package step2.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(String[] names) {
        this.players = Arrays.stream(names)
                .map(n -> new Player(n))
                .collect(Collectors.toList());
    }

    public Players(List<Player> players) {
        this.players = players;
    }

    public List<String> names() {
        return this.players.stream()
                .map(n -> new Player(n))
                .map(player -> player.name())
                .collect(Collectors.toList());
    }

    public int size() {
        return players.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Players)) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    @Override
    public String toString() {
        return "Names{" +
                "names=" + players +
                '}';
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Player player : players) {
            stringBuilder.append(String.format("%6s", player.print()));
        }
        return stringBuilder.toString();
    }
}

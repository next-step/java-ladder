package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Players {
    private final static String DELIMITER = ",";
    private List<Player> players;

    public Players(String players) {
        this(convertList(split(players)));
    }
    public Players(List<Player> players) {
        this.players = players;
    }

    private static List<Player> convertList(String[] players) {
        return Arrays.stream(players)
                .map(String::trim)
                .map(Player::new)
                .toList();
    }

    private static String[] split(String players) {
        return players.split(DELIMITER);
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public int getSize() {
        return this.players.size();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(players);
    }

    @Override
    public String toString() {
        return "Players{" +
                "players=" + players +
                '}';
    }
}

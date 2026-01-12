package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Players {
    private final static String DELIMITER = ",";
    private List<Player> players;

    public Players(String players) {
        this(convertList(split(players)));
    }

    public Players(List<Player> players) {
        this.players = players;
    }


    public List<Player> getPlayers() {
        return this.players;
    }

    public int getSize() {
        return this.players.size();
    }

    public int indexOf(String name) {
        return IntStream.range(0, players.size())
                .filter(i -> players.get(i).getName().equals(name))
                .findFirst()
                .orElse(-1);
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

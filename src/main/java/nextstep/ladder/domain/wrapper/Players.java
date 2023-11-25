package nextstep.ladder.domain.wrapper;

import nextstep.ladder.domain.Coordinate;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.exception.ExceptionMessage;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public String names() {
        return players.stream()
            .map(player -> String.format("%-6s", player.name()))
            .collect(Collectors.joining());
    }

    public Player findPlayerBy(Coordinate coordinate) {
        return players.stream()
            .filter(player -> player.isEqualCoordinate(coordinate))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_EXIST_PLAYER.message()));
    }

    public Player findPlayerBy(String name) {
        return players.stream()
            .filter(player -> player.isEqualName(name))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_EXIST_PLAYER.message()));
    }

    public int numOfPlayers() {
        return players.size();
    }

    public Player moveOne(int playerNo, Ladder ladder) {
        return ladder.climb(players.get(playerNo));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}

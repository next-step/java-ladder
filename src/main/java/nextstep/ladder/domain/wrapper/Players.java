package nextstep.ladder.domain.wrapper;

import nextstep.ladder.domain.Coordinate;
import nextstep.ladder.domain.Player;

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

    // TODO : 마무리해야함
    public Player findPlayerBy(Coordinate coordinate) {
        return players.stream()
            .filter(player -> player.isMatching(coordinate))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("해당 좌표 값에 존재하는 Player가 없습니다."));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    public void move(int playerNo, int x, int y) {
        players.get(playerNo)
            .move(x, y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}

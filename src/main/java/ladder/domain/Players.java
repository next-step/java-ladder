package ladder.domain;

import ladder.domain.factory.ILine;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public List<Player> players() {
        return players;
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
        return players != null ? players.hashCode() : 0;
    }

    public int count() {
        return players.size();
    }

    public Players move(ILine line) {
        return new Players(players.stream()
                .map(player -> player.move(line))
                .collect(toList()));
    }

    public Player findByPlayerName(PlayerName playerName) {
        return players.stream()
                .filter(player -> player.name().equals(playerName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(String.format("%s에 해당하는 플레이어가 없습니다.", playerName)));
    }

    public PlayerNames toPlayerNames() {
        return new PlayerNames(players.stream()
                .map(Player::name)
                .collect(toList()));
    }
}

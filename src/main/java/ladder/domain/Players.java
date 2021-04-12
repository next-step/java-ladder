package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(List<String> players) {
        this.players = players.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public static Players of(List<String> players) {
        return new Players(players);
    }

    public Position playerPosition(Player position) {
        Player matchedPlayer = players.stream()
                .filter(player -> player.equals(position))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("조건에 맞는 참가자를 찾을 수 없습니다."));

        if (matchedPlayer.equals(firstPlayer())) {
            return Position.FIRST;
        }

        if (matchedPlayer.equals(lastPlayer())) {
            return Position.LAST;
        }
        return Position.BODY;
    }

    private Player firstPlayer() {
        return players.get(0);
    }

    private Player lastPlayer() {
        return players.get(players.size() - 1);
    }

    public List<Player> allPlayers() {
        return players;
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

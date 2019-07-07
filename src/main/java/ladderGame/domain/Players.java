package ladderGame.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

    private final List<Player> players;

    private Players(List<String> playerNames) {
        this.players = IntStream.range(0, playerNames.size())
                .mapToObj(index -> Player.of(playerNames.get(index), index))
                .collect(Collectors.toList());
    }

    public static Players of(List<String> players) {
        return new Players(players);
    }

    public int size() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String getPlayerName(Position position) {
        return players.stream()
                .filter(player -> player.isEquals(position))
                .map(Player::getName)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 Position이 없습니다. "));
    }
}

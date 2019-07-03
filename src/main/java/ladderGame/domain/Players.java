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

    public void playGame(Ladder ladder) {
        players.forEach(ladder::rideLadder);
    }
}

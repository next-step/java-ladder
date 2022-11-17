package laddergame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<String> names) {
        this.players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public Players(String... names) {
        this(Arrays.asList(names));
    }

    public Players(Player... players) {
        this.players = Arrays.stream(players)
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public int count() {
        return this.players.size();
    }

    public void executeGame(Ladder ladder, Results results) {
        for (Player player : players) {
            int startIndex = players.indexOf(player);
            int endIndex = ladder.ride(startIndex);
            player.saveResult(results.find(endIndex));
        }
    }
}

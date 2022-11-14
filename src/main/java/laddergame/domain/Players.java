package laddergame.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<String> names) {
        this.players = names.stream().map(Player::new).collect(Collectors.toList());
    }

    public Players(String... names) {
        this(Arrays.asList(names));
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public int count() {
        return this.players.size();
    }

    public TotalResult startGame(Ladder ladder, List<String> result) {
        Map<Player, Result> total = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            total.put(players.get(i), new Result(result.get(ladder.ride(i))));
        }
        return new TotalResult(total);
    }
}

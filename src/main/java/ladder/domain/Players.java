package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private final List<Player> players;

    public Players(List<String> players) {
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException("Players list cannot be null or empty");
        }

        this.players = IntStream.range(0, players.size())
                .mapToObj(i -> new Player(players.get(i), i))
                .collect(Collectors.toList());
    }

    public int count() {
        return players.size();
    }

    public Player getPlayerAtIndex(int i) {
        return players.get(i);
    }

    public List<Integer> traverse(Ladder ladder) {
        if (ladder == null) {
            throw new IllegalArgumentException("Ladder cannot be null");
        }

        if (ladder.width() != players.size()) {
            throw new IllegalArgumentException("Ladder width must match the number of players");
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            result.add(ladder.traverse(i));
        }

        return result;
    }
}

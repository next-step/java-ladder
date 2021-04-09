package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ladder.utils.StringSpliter;

public class Players {
    private final List<Player> players = new ArrayList<>();

    public Players(String names) {
        String[] splitNames = StringSpliter.split(names);
        for (int i = 0; i < splitNames.length; i++) {
            players.add(new Player(i, splitNames[i]));
        }
    }

    public int playerCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }
}

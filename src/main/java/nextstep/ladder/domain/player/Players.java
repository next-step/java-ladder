package nextstep.ladder.domain.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Players {
    private List<Player> players = new ArrayList<>();

    public Players(String[] names) {
        Arrays.stream(names)
                .forEach(name -> players.add(new Player(name)));
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getPlayerCount() {
        return players.size();
    }
}

package ladder.user;

import java.util.ArrayList;
import java.util.List;
import ladder.ladder.Position;

public class Players {

    private final List<Player> players = new ArrayList<>();

    public Players(UserNames userNames) {
        for (int i = 0; i < userNames.size(); i++) {
            players.add(new Player(userNames.getUserNames().get(i), new Position(i)));
        }
    }

    public int size() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}

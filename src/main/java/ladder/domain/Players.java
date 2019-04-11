package ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public Players(String[] names) {
        int idx = 0;
        List<Player> playerNames = new ArrayList<>();
        for (String name : names) {
            playerNames.add(new Player(name, idx++));
        }
        this.players = playerNames;
    }

    public int size() {
        return players.size();
    }

    public Iterator<Player> iterator() {
        return players.iterator();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Player player : players) {
            stringBuffer.append(player.toString());
        }
        return stringBuffer.toString();
    }
}

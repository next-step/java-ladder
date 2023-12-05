package ladder.domain;

import java.lang.reflect.Member;
import java.util.List;

public class Players {
    private List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public int membersCount(){
        return players.size();
    }

    public List<Player> getPlayers(){
        return players;
    }
}

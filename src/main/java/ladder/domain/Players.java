package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Players {

    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public List<Player> players(){
        return Collections.unmodifiableList(players);
    }

    public Integer count(){
        return players.size();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players that = (Players) o;
        return Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}


package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Players {

    private final List<Player> playerList;

    public Players(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Player> players(){
        return Collections.unmodifiableList(playerList);
    }

    public int count(){
        return playerList.size();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players that = (Players) o;
        return Objects.equals(playerList, that.playerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerList);
    }
}


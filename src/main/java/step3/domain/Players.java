package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private List<Player> playerList = new ArrayList<>();

    public Players(List<Player> playerList) {
        this.playerList = playerList;
    }

    public int size() {
        return this.playerList.size();
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public Player get(int index) {
        return playerList.get(index);
    }

}

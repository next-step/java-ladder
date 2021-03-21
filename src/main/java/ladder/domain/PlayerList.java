package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerList {

    List<Player> playerList = new ArrayList<>();

    public void addBulk(String[] nameArray) {
        for (int i = 0; i < nameArray.length; i++) {
            add(nameArray[i], i);
        }
    }

    private void add(String name, int ladderNumber) {
        playerList.add(new Player(name, ladderNumber));
    }

    public int size() {
        return playerList.size();
    }

    public List<Player> playerList() {
        return Collections.unmodifiableList(new ArrayList<>(playerList));
    }
}

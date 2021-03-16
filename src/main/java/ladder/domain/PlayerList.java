package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerList {

    List<Player> playerList = new ArrayList<>();

    public void addBulk(String[] nameArray) {
        Arrays.stream(nameArray)
                .forEach(this::add);
    }

    private void add(String name) {
        playerList.add(new Player(name));
    }


    public int size() {
        return playerList.size();
    }
}

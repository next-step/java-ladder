package ladder;

import java.util.ArrayList;
import java.util.List;

public class Players {

    List<Player> playerList = new ArrayList<>();

    public Players(String playerNames) {
        String[] names = playerNames.split(",");

        for (String name : names) {
            playerList.add(new Player(name));
        }
    }
}

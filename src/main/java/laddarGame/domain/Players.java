package laddarGame.domain;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private List<Player> playerList;
    private static final String DELIMITER = ",";


    public Players(String playerNames) {
        String[] names = nameParser(playerNames);
        this.playerList = playerList(names);
    }

    private List<Player> playerList(String[] names) {
        List<Player> players = new ArrayList<>();
        for (int position = 0; position < names.length; position++) {
            players.add(new Player(names[position], position));
        }
        return players;
    }

    public List<Player> toList() {
        return playerList;
    }

    public String[] nameParser(String playerNames) {
        return playerNames.split(DELIMITER);
    }


}

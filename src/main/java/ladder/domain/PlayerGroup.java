package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerGroup {

    private final List<Player> playerList;
    private static final String DELIMITER = ",";

    public PlayerGroup(String playerNames) {
        this.playerList = convertToList(playerNames);
    }

    public List<String> getPlayerNames() {
        return playerList.stream()
                .map(player -> player.name())
                .collect(Collectors.toUnmodifiableList());
    }

    private List<Player> convertToList(String playerNames) {
        return Arrays.stream(playerNames.split(DELIMITER))
                .map(name -> new Player(name.trim()))
                .collect(Collectors.toUnmodifiableList());
    }

    public int size() {
        return playerList.size();
    }
}

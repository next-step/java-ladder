package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

    public final static String PLAYER_DELIMITER = ",";

    List<Player> players = new ArrayList<>();

    public Players(String players) {
        String[] playerArray = players.split(PLAYER_DELIMITER);
        this.players = IntStream.range(0, playerArray.length)
                .mapToObj(i -> new Player(playerArray[i], i))
                .collect(Collectors.toList());
    }

    public int getPlayerCount() {
        return players.size();
    }

    public List<String> getPlayerName() {
        return players.stream()
                    .map(p -> p.getName())
                    .collect(Collectors.toList());
    }
}

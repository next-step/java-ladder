package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    public final static String PLAYER_DELIMITER = ",";

    List<Player> players = new ArrayList<>();

    public Players(String players) {
        this.players = Arrays.stream(players.split(PLAYER_DELIMITER))
                        .map(Player::new)
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

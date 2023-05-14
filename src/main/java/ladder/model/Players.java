package ladder.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    public Players(String[] names) {
        players= Arrays.stream(names)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers(){
        return Collections.unmodifiableList(players);
    }

    public int getNumPlayers() {
        return players.size();
    }

}

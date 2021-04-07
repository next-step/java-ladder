package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    public Players(String[] players){
        this.players = Arrays.stream(players)
                            .map(Player::new)
                            .collect(Collectors.toList());
    }

    public int numberOfPlayer(){
        return players.size();
    }

    public List<Player> players(){
        return Collections.unmodifiableList(players);
    }
}

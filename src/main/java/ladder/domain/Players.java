package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    public Players(String[] players){
        this.players = Arrays.stream(players)
                            .map(Player::new)
                            .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < players.size(); i++){
            result.append(players.get(i).toString());
        }
        return result.toString();
    }
}

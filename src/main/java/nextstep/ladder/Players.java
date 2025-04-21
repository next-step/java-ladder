package nextstep.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players = new ArrayList<>();

    public Players(String names) {
        this.players = Arrays.stream(names.split(","))
                .map(String::trim)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getCount() {
        return players.size();
    }
}

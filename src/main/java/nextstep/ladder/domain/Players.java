package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(String input) {
        this.players = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public int size() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<String> getPlayersName() {
        List<String> names = new ArrayList<>();
        players.forEach(player -> names.add(player.getName()));

        return names;
    }
}

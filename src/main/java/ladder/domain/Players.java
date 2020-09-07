package ladder.domain;

import ladder.util.StringUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(String names) {
        this.players = StringUtil.convertList(names)
                .stream()
                .map(name -> Player.of(name))
                .collect(Collectors.toList());
    }

    public static Players of(String names){
        return new Players(names);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public int getCountOfPlayers() {
        return this.players.size();
    }
}

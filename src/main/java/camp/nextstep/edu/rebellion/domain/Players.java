package camp.nextstep.edu.rebellion.domain;

import camp.nextstep.edu.rebellion.util.StringUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(String input) {
        this.players =  StringUtil.convertList(input)
                .stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int getCountOfPlayers() {
        return this.players.size();
    }
}

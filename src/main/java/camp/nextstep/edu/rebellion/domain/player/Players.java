package camp.nextstep.edu.rebellion.domain.player;

import camp.nextstep.edu.rebellion.util.StringUtil;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(String input) {
        AtomicInteger position = new AtomicInteger(0);
        this.players = StringUtil.convertList(input)
                .stream()
                .map(name -> new Player(name, position.getAndIncrement()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int getCountOfPlayers() {
        return this.players.size();
    }
}

package ladder.domain.player;

import ladder.util.StringUtil;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(String names) {
        AtomicInteger position = new AtomicInteger(0);
        this.players = StringUtil.convertList(names)
                .stream()
                .map(name -> Player.builder()
                        .name(name)
                        .position(position.getAndIncrement())
                        .build())
                .collect(Collectors.toList());
    }

    public static Players of(String names){
        return new Players(names);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int getCountOfPlayers() {
        return this.players.size();
    }
}

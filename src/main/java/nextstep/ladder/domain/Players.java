package nextstep.ladder.domain;

import java.util.List;

public class Players {

    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public Player find(String name) {
        return players.stream()
                .filter(player -> player.isSameName(name))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("존재하지 않는 플레이어입니다.")
                );
    }
}

package nextstep.ladder.domain.player;

import java.util.List;
import java.util.Optional;

public class Players {

    private final List<Player> playerList;

    public Players(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Optional<Player> searchBy(Name name) {
        return playerList.stream().filter(player -> player.hasName(name)).findFirst();
    }

}

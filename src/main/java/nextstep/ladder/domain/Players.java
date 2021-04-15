package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> playerList;

    public Players(List<String> names) {
        playerList = new ArrayList<>(names.size());
        names.stream()
                .map(Player::new)
                .forEach(playerList::add);
    }

    public List<String> getAllPlayerNames() {
        return playerList.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public int getPlayerCount() {
        return playerList.size();
    }
}

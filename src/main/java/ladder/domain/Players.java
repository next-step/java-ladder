package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> playerList = new ArrayList<>();

    public Players(List<String> nameList) {
        nameList.forEach((name) -> this.playerList.add(new Player(name)));
    }

    public List<String> names() {
        return playerList.stream()
                .map(Player::name)
                .collect(Collectors.toList());
    }
}

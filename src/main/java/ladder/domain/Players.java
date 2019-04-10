package ladder.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Getter
public class Players {
    private List<Player> players = new ArrayList<>();

    Players(List<String> inputPlayers) {
        inputPlayers.forEach(inputPlayer -> {
            players.add(new Player(inputPlayer));
        });
    }

    public int maxNameLength() {
        return Collections.max(players, Comparator.comparing(Player::getNameLength)).getNameLength();
    }

    public int playerIndex(String UserName) {
        return players.indexOf(new Player(UserName));
    }
}

package step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static step3.view.InputView.DELIMITER;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public static Players from(String inputPlayers) {
        return new Players(Arrays.stream(inputPlayers.split(DELIMITER)).map(Player::new).collect(Collectors.toList()));
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int size(){
        return players.size();
    }
}

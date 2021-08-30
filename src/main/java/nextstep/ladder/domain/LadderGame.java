package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private List<Player> players;
    private int height;

    public LadderGame(List<String> players, int height) {
        this.players = players.stream()
                .map(Player::new)
                .collect(Collectors.toList());
        this.height = height;
    }

}

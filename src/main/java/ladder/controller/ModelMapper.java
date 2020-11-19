package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.view.RequestView;

import java.util.stream.Collectors;

public class ModelMapper {
    private ModelMapper() {}

    static Players getPlayers() {
        return new Players(RequestView.askPlayers()
                .getPlayers()
                .stream()
                .map(player -> new Player(player))
                .collect(Collectors.toList())
        );
    }

    static Ladder getLadder() {
        return new Ladder(RequestView.askLadderHeight()
                .getHeight()
        );
    }
}

package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.view.Input;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    public static void main(String[] args) {
        List<String> playersAsString = Input.askPlayers();
        List<Player> players = playersAsString.stream()
                .map(Player::new)
                .collect(Collectors.toList());

        int height = Input.askLadderHeight();
        Ladder ladder = Ladder.of(players.size() - 1, height);
        ladder.initialize(height);
    }
}

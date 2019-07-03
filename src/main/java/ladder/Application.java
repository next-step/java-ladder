package ladder;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.InputView;

public class Application {

    public static void main(String[] args) {
        Players players = Players.of(InputView.askPlayers());
        Height height = Height.from(InputView.askHeight());

        Ladder.from(height, players);
    }
}

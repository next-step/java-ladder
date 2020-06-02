package ladder;

import ladder.domain.ladder.Height;
import ladder.domain.player.Players;
import ladder.view.InputView;

public class LadderApplication {

    public static void main(String[] args) {
        Players players = Players.of(InputView.inputPlayers());
        Height height = Height.of(InputView.inputHeight());
    }
}

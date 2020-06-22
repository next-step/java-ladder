package ladder;

import ladder.domain.ladder.Ladder;
import ladder.domain.line.Height;
import ladder.domain.player.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

public class MainApplication {

    public static void main(String[] args) {
        Players players = InputView.readPlayers();
        Height height = InputView.readHeight();

        Ladder ladder = Ladder.create(players, height);

        ResultView.printPlayers(players);
        ResultView.printLines(ladder.getLines());
    }
}

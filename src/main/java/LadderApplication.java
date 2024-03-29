import domain.Height;
import domain.Ladder;
import domain.Player;
import domain.Players;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {
        Players players = InputView.promptForPlayer();
        Height height = InputView.promptForHeight();
        Ladder ladder = Ladder.of(players, height);

        ResultView.print(ladder);
    }
}

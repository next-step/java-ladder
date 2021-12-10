package ladder;

import ladder.controller.LadderController;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.user.Players;
import ladder.strategy.RandomLine;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        Players players = new Players(InputView.printInputNames());
        LadderHeight height = new LadderHeight(InputView.printInputLadderHeight());

        LadderController controller = new LadderController(new RandomLine());
        Ladder ladder = controller.createLadder(players, height);

        ResultView.printResult(players.getPlayers(), ladder.getLines());
        ResultView.printLadder(ladder.getLines());
    }

}

package ladder.domain;

import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public void run() {
        Users users = new Users(InputView.inputGameUser());
        int countOfPlayers = users.getPlayerCount();
        Ladder ladder = new Ladder(countOfPlayers, InputView.inputLadderSize(), new RightPointRandom());

        ResultView.printUserNames(users.getUserNames());
        ResultView.printLines(ladder.getLines());
    }
}

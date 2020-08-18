package camp.nextstep.edu.rebellion;

import camp.nextstep.edu.rebellion.domain.Ladder;
import camp.nextstep.edu.rebellion.domain.LadderGame;
import camp.nextstep.edu.rebellion.view.ResultView;

public class LadderGameRunner {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(5, 5);
        Ladder ladder = ladderGame.make();
        ResultView.printLadder(ladder);
    }
}
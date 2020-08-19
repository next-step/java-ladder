package camp.nextstep.edu.rebellion;

import camp.nextstep.edu.rebellion.domain.Ladder;
import camp.nextstep.edu.rebellion.domain.LadderGame;
import camp.nextstep.edu.rebellion.domain.Players;
import camp.nextstep.edu.rebellion.domain.rule.AlwaysDrawingRule;
import camp.nextstep.edu.rebellion.view.InputView;
import camp.nextstep.edu.rebellion.view.ResultView;

public class LadderGameRunner {
    public static void main(String[] args) {
        String playerInput = InputView.getPlayers();
        int rows = InputView.getRows();

        Players players = new Players(playerInput);

        LadderGame ladderGame = new LadderGame(players, rows);
        Ladder ladder = ladderGame.make(new AlwaysDrawingRule());

        ResultView.printPlayers(players);
        ResultView.printLadder(ladder);
    }
}

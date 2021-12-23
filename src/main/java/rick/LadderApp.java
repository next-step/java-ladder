package rick;

import rick.domain.Ladder;
import rick.domain.Players;
import rick.strategy.RandomLineCreationStrategy;
import rick.view.InputView;
import rick.view.ResultView;

public class LadderApp {

    public static void main(String[] args) {
        Players players = InputView.getPlayerNames();
        int ladderLineCount = InputView.getLadderLineCount();
        Ladder ladder = new Ladder(players.playerCount(), ladderLineCount, new RandomLineCreationStrategy());
        ResultView.drawResult(players, ladder);
    }
}

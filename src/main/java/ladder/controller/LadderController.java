package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Prize;
import ladder.view.InputView;
import ladder.view.LadderResultView;
import ladder.view.PrizeResultView;

public class LadderController {
    public void startLadderGame() {
        try {
            InputView inputView = new InputView();
            Players players = inputView.inputPlayer();
            Prize prize = inputView.inputPrize(players.count());
            int ladderHeight = inputView.inputLadderHeight();

            Ladder ladder = Ladder.make(players.count(), ladderHeight);

            LadderResultView ladderResultView = new LadderResultView(players, ladder);
            ladderResultView.showLadderDrawResult(prize);

            PrizeResultView prizeResultView = new PrizeResultView(ladderResultView.getLadderResult(), prize);
            
            System.out.println();
            String prizePlayerName;
            boolean isAll = false;
            while (!isAll) {
                prizePlayerName = inputView.inputPlayerNameForPrize();
                isAll = prizePlayerName.equalsIgnoreCase("ALL");
                prizeResultView.printPrizeResult(isAll, prizePlayerName, players);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

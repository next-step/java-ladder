package rick;

import rick.domain.Ladder;
import rick.domain.Players;
import rick.domain.Rewards;
import rick.strategy.RandomLineCreationStrategy;
import rick.view.InputView;
import rick.view.ResultView;

public class LadderApp {

    public static void main(String[] args) {
        Players players = InputView.getPlayerNames();
        Rewards rewards = InputView.getRewards();
        int ladderLineCount = InputView.getLadderLineCount();
        Ladder ladder = new Ladder(players.playerCount(), ladderLineCount, new RandomLineCreationStrategy());
        ResultView.drawLadder(players, rewards, ladder);

        while (showResult(players, rewards, ladder))
            ;
    }

    private static boolean showResult(Players players, Rewards rewards, Ladder ladder) {
        String playerName = InputView.getPlayerNameForResult();
        if (playerName.equals("all")) {
            ResultView.drawAllRewards(players, rewards, ladder);
            return false;
        }

        ResultView.drawPlayerResult(players, rewards, ladder, playerName);
        return true;
    }
}

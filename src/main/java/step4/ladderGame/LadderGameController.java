package step4.ladderGame;

import step4.ladderGame.domain.award.Awards;
import step4.ladderGame.domain.ladder.GenerateDirectionStrategy.GenerateRandomDirectionStrategy;
import step4.ladderGame.domain.ladder.Ladder;
import step4.ladderGame.domain.palyer.Players;
import step4.ladderGame.view.InputView;
import step4.ladderGame.view.ResultView;

public final class LadderGameController {

    public static void main(String[] args) {
        Players players = new Players(InputView.inputPlayers());
        Awards awards = new Awards(InputView.inputAwards(), players.count());
        int height = InputView.inputHeight();
        Ladder ladder = new Ladder(players.count(), height, new GenerateRandomDirectionStrategy());

        ResultView.printPlayers(players);
        ResultView.printLadder(ladder);
        ResultView.printAwards(awards);

        playGame(players, awards, ladder);
    }

    private static void playGame(final Players players, final Awards awards, final Ladder ladder) {
        boolean play = true;
        while (play) {
            play = checkAward(players, awards, ladder);
        }
    }

    private static boolean checkAward(final Players players, final Awards awards, final Ladder ladder) {
        String player = InputView.inputPlayer();
        if ("all".equals(player)) {
            ResultView.printWinningAwardAll(players, awards, ladder);
            return false;
        }
        ResultView.printWinningAward(ladder.move(players.findIndex(player)), awards);
        return true;
    }

}

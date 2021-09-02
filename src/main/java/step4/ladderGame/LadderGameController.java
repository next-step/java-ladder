package step4.ladderGame;

import step4.ladderGame.domain.award.Awards;
import step4.ladderGame.domain.ladder.Ladder;
import step4.ladderGame.domain.palyer.Players;
import step4.ladderGame.view.InputView;
import step4.ladderGame.view.ResultView;

public class LadderGameController {

    public static void main(String[] args) {
        Players players = new Players(InputView.inputPlayers());
        Awards awards = new Awards(InputView.inputAwards(), players.count());
        int height = InputView.inputHeight();
        Ladder ladder = new Ladder(players.count(), height);

        ResultView.printPlayers(players);
        ResultView.printLadder(ladder);
        ResultView.printAwards(awards);

        playGame(players, awards, ladder);
    }

    private static void playGame(Players players, Awards awards, Ladder ladder) {
        boolean play = true;
        while (play) {
            play = checkAward(players, awards, ladder);
        }
    }

    private static boolean checkAward(Players players, Awards awards, Ladder ladder) {
        String player = InputView.inputPlayer();
        if ("all".equals(player)) {
            ResultView.printWinningAwardAll(players, awards, ladder);
            return false;
        }
        ResultView.printWinningAward(ladder.move(players.findIndex(player)), awards);
        return true;
    }

}

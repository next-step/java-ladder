package step3.ladderGame;

import step3.ladderGame.domain.award.Awards;
import step3.ladderGame.domain.ladder.Ladder;
import step3.ladderGame.domain.palyer.Players;
import step3.ladderGame.view.InputView;
import step3.ladderGame.view.ResultView;

import java.util.Arrays;
import java.util.List;

public class LadderGameController {

    public static void main(String[] args) {
        List<String> playerNames = Arrays.asList(InputView.inputPlayers());
        Players players = new Players(playerNames);
        List<String> awardNames = Arrays.asList(InputView.inputAwards());
        Awards awards = new Awards(awardNames, playerNames.size());
        int height = InputView.inputHeight();
        Ladder ladder = new Ladder(playerNames.size(), height);

        ResultView.printPlayers(playerNames);
        ResultView.printLadder(ladder);
        ResultView.printAwards(awardNames);

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

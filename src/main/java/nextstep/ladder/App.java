package nextstep.ladder;

import nextstep.ladder.factory.LadderFactory;
import nextstep.ladder.ladder.*;
import nextstep.ladder.player.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class App {

    public static void main(String[] args) {
        LadderPrizes ladderPrizes = getLadderPrizes();
        int height = InputView.getInputMaxLadderHeight();

        Players players = ladderPrizes.getPlayers();
        Prizes prizes = ladderPrizes.getPrizes();
        Ladder ladder = Ladder.of(LadderBound.of(players.count() - 1, height), LadderFactory.randomLadderStrategy());

        LadderGame ladderGame = new LadderGame(players, ladder);
        ladderGame.play();
        ResultView.printLadder(players, ladder, prizes);
        ResultView.printPlayerResult(ladderGame, prizes);

    }

    private static LadderPrizes getLadderPrizes() {
        String playerNames = InputView.getInputPlayerName();
        String prizesNames = InputView.getInputLadderPrize();
        return LadderPrizes.of(playerNames, prizesNames);
    }
}

package nextstep.ladder;

import java.util.List;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.PrizeSheet;
import nextstep.ladder.domain.model.Prize;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Main {
  public static void main(String[] args) {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    Players players = inputView.acceptPlayers();
    List<String> prizes = inputView.writePrizes();
    int ladderHeight = inputView.askLadderHeight();

    LadderGame ladderGame = new LadderGame(prizes, ladderHeight);

    resultView.printLadderResult(ladderGame, players);
    resultView.printPrizes(prizes);
    resultView.printWinningResult(ladderGame.play(players));
  }
}

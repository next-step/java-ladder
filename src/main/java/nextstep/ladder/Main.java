package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.PrizeSheet;
import nextstep.ladder.domain.ResultSheet;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Main {
  public static void main(String[] args) {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    Players players = inputView.acceptPlayers();
    PrizeSheet prizeSheet = inputView.writePrizes();
    int ladderHeight = inputView.askLadderHeight();

    Ladder ladder = new Ladder(ladderHeight, prizeSheet.getSize());
    resultView.printLadderResult(ladder, players);
    prizeSheet.print();

    ResultSheet resultSheet = players.produceResult(ladder, prizeSheet);
    resultView.printWinningResult(resultSheet);
  }
}

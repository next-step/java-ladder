package nextstep.ladder;

import java.util.List;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Main {
  public static void main(String[] args) {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    Players players = inputView.acceptPlayers();
    List<String> prizes = inputView.writePrizes();
    int ladderHeight = inputView.askLadderHeight();


  }
}

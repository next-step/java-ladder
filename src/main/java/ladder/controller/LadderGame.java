package ladder.controller;

import ladder.model.Height;
import ladder.model.line.Ladder;
import ladder.model.member.Players;
import ladder.strategy.RandomLadderPointsStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Scanner;

public class LadderGame {

  private final InputView inputView;
  private final ResultView resultView = new ResultView();

  public LadderGame() {
    inputView = new InputView(new Scanner(System.in));
  }

  public void run() {

    Players players = Players.initNames(inputView.nameInputEvent());
    Height height = new Height(inputView.heightInputEvent());

    Ladder ladder = Ladder.makeLadder(height, players.size(), new RandomLadderPointsStrategy());
    resultView.showResult(players, ladder);
  }
}

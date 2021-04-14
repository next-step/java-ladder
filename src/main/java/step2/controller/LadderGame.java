package step2.controller;

import step2.model.Height;
import step2.model.line.Ladder;
import step2.model.name.Names;
import step2.strategy.RandomLadderPointsStrategy;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.Scanner;

public class LadderGame {

  private final InputView inputView;
  private final ResultView resultView = new ResultView();

  public LadderGame() {
    inputView = new InputView(new Scanner(System.in));
  }

  public void run() {

    Names names = Names.initNames(inputView.nameInputEvent());
    Height height = new Height(inputView.heightInputEvent());

    Ladder ladder = Ladder.makeLadder(height, names.size(), new RandomLadderPointsStrategy());
    resultView.showResult(names, ladder);
  }
}

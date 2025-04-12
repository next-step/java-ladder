package nextstep.ladder.service;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.RandomLineGenerateStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.Scanner;

public class LadderGame {
  private final InputView inputView;
  private Players players;
  private Ladder ladder;


  public LadderGame(Scanner scanner) {
    this.inputView = new InputView(scanner);
  }

  public void run() {
    setUpForGame();
    printResult();
  }

  private void setUpForGame() {
    this.players = new Players(inputView.readPlayers());
    this.ladder = new Ladder(inputView.readLadderHeight(), players, new RandomLineGenerateStrategy());
  }

  private void printResult() {
    OutputView.printResult(players, ladder);
  }
}

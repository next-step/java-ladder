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
    printLadder();
  }

  private void setUpForGame() {
    this.players = new Players(inputView.readPlayers());
    int ladderHeight = inputView.readLadderHeight();
    String result = inputView.readResult();
    this.ladder = new Ladder(ladderHeight, players, new RandomLineGenerateStrategy(), result);
  }

  private void printLadder() {
    OutputView.printResult(players, ladder);
  }
}

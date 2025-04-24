package nextstep.ladder.service;

import nextstep.ladder.domain.GameResult;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.RandomLineGenerateStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.Scanner;

public class LadderGame {
  private static final String ALL_RESULT = "all";
  private final InputView inputView;
  private Players players;
  private Ladder ladder;


  public LadderGame(Scanner scanner) {
    this.inputView = new InputView(scanner);
  }

  public void run() {
    setUpForGame();
    printLadder();
    showResult(play());
  }

  private void setUpForGame() {
    String players = inputView.readPlayers();
    String result = inputView.readResult();
    int ladderHeight = inputView.readLadderHeight();

    this.players = new Players(players);
    this.ladder = new Ladder(ladderHeight, this.players, new RandomLineGenerateStrategy(), result);
  }

  private void printLadder() {
    OutputView.printLadder(players, ladder);
  }

  private GameResult play() {
    GameRunner gameRunner = new GameRunner(ladder, players);
    return gameRunner.run();
  }

  private void showResult(GameResult gameResult) {
    while (true) {
      String query = inputView.readResultQuery();

      if (query.equals(ALL_RESULT)) {
        OutputView.printAllResult(gameResult.getAllResults());
        break;
      }

      if (players.contains(query)) {
        OutputView.printResult(gameResult.getResult(Player.of(query)));
      }
    }
  }
}

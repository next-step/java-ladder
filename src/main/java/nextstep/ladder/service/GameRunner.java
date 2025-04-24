package nextstep.ladder.service;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.GameResult;

public class GameRunner {
  private final Ladder ladder;
  private final Players players;
  private GameResult gameResult;

  public GameRunner(Ladder ladder, Players players) {
    this.ladder = ladder;
    this.players = players;
  }

  public GameResult run() {
    return new GameResult(players.playAll(ladder));
  }
}

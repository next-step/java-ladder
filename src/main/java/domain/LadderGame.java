package domain;

import domain.strategy.HorizontalLineDrawingStrategy;

public class LadderGame {

  private Players players;
  private Ladder ladder;

  public LadderGame(String names, int ladderHeight, HorizontalLineDrawingStrategy strategy) {
    this.players = new Players(names);
    this.ladder = new Ladder(ladderHeight, players.getPlayers().size(), strategy);
  }

  public Players getPlayers() {
    return players;
  }

  public Ladder getLadder() {
    return ladder;
  }

}

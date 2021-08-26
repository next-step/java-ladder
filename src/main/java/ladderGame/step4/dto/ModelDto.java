package ladderGame.step4.dto;

import ladderGame.step4.model.Ladder;
import ladderGame.step4.model.Players;
import ladderGame.step4.model.Prizes;

public class ModelDto {

  private final Players players;

  private final Ladder ladder;

  private final Prizes prizes;

  public ModelDto(final Players players, final Ladder ladder, final Prizes prizes) {
    this.players = players;
    this.ladder = ladder;
    this.prizes = prizes;
  }

  public Players getPlayers() {
    return players;
  }

  public Ladder getLadder() {
    return ladder;
  }

  public Prizes getPrizes() {
    return prizes;
  }
}
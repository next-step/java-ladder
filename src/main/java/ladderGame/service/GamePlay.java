package ladderGame.service;

import ladderGame.model.Lines;
import ladderGame.model.Players;

public class GamePlay {

  private final Players player;

  private final Lines lines;

  public GamePlay(final String stringNames, final int height) {
    this.player = new Players(CreatePlayer.createUser(stringNames));
    this.lines = new Lines(height, this.player.findPlayersCount());
  }

  public Players getPlayer() {
    return player;
  }

  public Lines getLines() {
    return lines;
  }
}
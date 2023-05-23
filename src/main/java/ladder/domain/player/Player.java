package ladder.domain.player;

import ladder.domain.ladder.line.point.LadderPointDirection;

public class Player {

  private final PlayerName playerName;
  private final PlayerPosition playerPosition;

  public Player(String name, int currentLine) {
    this.playerName = new PlayerName(name);
    this.playerPosition = new PlayerPosition(currentLine);
  }

  public String getPlayerName() {
    return this.playerName.getName();
  }
  public int getCurrentHeight() {
    return this.playerPosition.getCurrentHeight();
  }

  public int getCurrentLine() {
    return this.playerPosition.getCurrentLine();
  }

  public void move(LadderPointDirection direction) {
    this.playerPosition.move(direction);
  }
}

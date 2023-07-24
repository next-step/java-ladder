package nextstep.ladder.domain;

public class Player {
  private final PlayerName playerName;

  private final String result;

  public Player(PlayerName playerName, String result) {
    this.playerName = playerName;
    this.result = result;
  }

  public String getResult() {
    return this.result;
  }

  public PlayerName getPlayerName() {
    return this.playerName;
  }
}

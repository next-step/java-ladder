package ladder;

public class LadderGameInformation {

  private final Players players;
  private final int ladderHeight;

  public LadderGameInformation(Players players, int ladderHeight) {
    this.players = players;
    this.ladderHeight = ladderHeight;
  }

  public int playersCount() {
    return players.count();
  }

  public int ladderHeight() {
    return ladderHeight;
  }

  public String getLengthFormatPlayersName() {
    return players.toString();
  }
}

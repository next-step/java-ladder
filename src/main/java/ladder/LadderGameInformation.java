package ladder;

public class LadderGameInformation {

  private static final int DEFAULT_PLAYERS_NAME_FORMAT_LENGTH = 6;
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

  public String getLengthFormatPlayersName(int length) {
    return players.getLengthFormatPlayersName(length);
  }

  public String getLengthFormatPlayersName() {
    return players.getLengthFormatPlayersName(DEFAULT_PLAYERS_NAME_FORMAT_LENGTH);
  }
}

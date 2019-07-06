package ladder;

import java.util.List;

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

  public int getPlayerPosition(String playerName) {
    return players.getPlayerPosition(playerName);
  }

  public List<Player> getPlayers() {
    return players.getPlayers();
  }

}

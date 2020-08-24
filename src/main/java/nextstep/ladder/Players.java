package nextstep.ladder;

import java.util.List;

public class Players {

  private List<String> playerNames;
  private int ladderHeight;

  Players(List<String> playerNames, int ladderHeight) {
    this.playerNames = playerNames;
    this.ladderHeight = ladderHeight;
  }

  public List<String> getPlayerNames() {
    return playerNames;
  }

  public int countOfPerson(){
    return playerNames.size();
  }

  public int getLadderHeight() {
    return ladderHeight;
  }



  public static Players valueOf(List<String> playerNames, int ladderHeight) {
    return new Players(playerNames, ladderHeight);
  }

}

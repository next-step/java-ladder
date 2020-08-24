package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

  public static Players valueOf(String playerNames, int ladderHeight) {
    return new Players(namesToList(playerNames), ladderHeight);
  }

  private static List<String> namesToList(String playerNames) {
    return Arrays.stream(playerNames.split(","))
        .collect(Collectors.toList());
  }

}

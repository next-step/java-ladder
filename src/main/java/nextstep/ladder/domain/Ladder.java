package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ladder {
  private final LadderPoints ladderPoints;
  public Ladder(LadderPoints ladderPoints) {
    this.ladderPoints = ladderPoints;
  }

  public LadderPoints ladderPoints() {
    return this.ladderPoints;
  }

  public List<Player> play(PlayerNames playerNames, Map<Integer, String> rewards) {
    PlayerStatuses playerStatuses = new PlayerStatuses(playerNames, this.ladderPoints);

    List<PlayerStatus> results = playerStatuses.go();
    List<Player> players = new ArrayList<>();
    for (PlayerStatus playerStatus : results) {
      String reward = rewards.get(playerStatus.getLocation().getX());
      players.add(new Player(playerStatus.getPlayerName(), reward));
    }

    return players;
  }
}
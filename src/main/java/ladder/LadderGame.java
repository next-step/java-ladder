package ladder;

import java.util.List;

public class LadderGame {

  LadderGameInformation ladderGameInformation;
  Ladder ladder;

  public LadderGame(LadderGameInformation ladderGameInformation) {
    this.ladderGameInformation = ladderGameInformation;
  }

  public Ladder makeLadder() {
    ladder = new Ladder(ladderGameInformation.ladderHeight(), ladderGameInformation.playersCount());
    return ladder;
  }

  public LadderGameResult getAllPlayerResult(LadderResult result) {
    LadderGameResult gameResult = new LadderGameResult();
    List<Player> playerList = ladderGameInformation.getPlayers();
    for (int i = 0; i < playerList.size(); i++) {
      gameResult.add(playerList.get(i), result.getLadderResult(ladder.move(i)));
    }
    return gameResult;
  }

}

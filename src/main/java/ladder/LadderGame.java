package ladder;

public class LadderGame {

  LadderGameInformation ladderGameInformation;

  public LadderGame(LadderGameInformation ladderGameInformation) {
    this.ladderGameInformation = ladderGameInformation;
  }

  public Ladder makeLadder() {
    return new Ladder(ladderGameInformation.ladderHeight(), ladderGameInformation.playersCount());
  }
}

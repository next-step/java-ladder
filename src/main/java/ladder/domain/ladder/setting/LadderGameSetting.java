package ladder.domain.ladder.setting;

import ladder.domain.ladder.ladder.DefaultLadderGenerator;
import ladder.domain.ladder.ladder.LadderGenerator;
import ladder.domain.ladder.simulator.DefaultLadderGameSimulator;
import ladder.domain.ladder.simulator.LadderGameSimulator;

public class LadderGameSetting {

  private final LadderGenerator ladderGenerator;
  private final LadderGameSimulator gameSimulator;

  public LadderGameSetting() {
    this.ladderGenerator = new DefaultLadderGenerator();
    this.gameSimulator = new DefaultLadderGameSimulator();
  }

  public LadderGameSetting(LadderGenerator ladderGenerator) {
    this.ladderGenerator = ladderGenerator;
    this.gameSimulator = new DefaultLadderGameSimulator();
  }

  public LadderGenerator getLadderGenerator() {
    return ladderGenerator;
  }

  public LadderGameSimulator getGameSimulator() {
    return gameSimulator;
  }
}

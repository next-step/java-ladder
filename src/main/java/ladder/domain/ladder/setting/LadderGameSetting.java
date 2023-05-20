package ladder.domain.ladder.setting;

import ladder.domain.ladder.ladder.DefaultLadderGenerator;
import ladder.domain.ladder.ladder.Ladder;
import ladder.domain.ladder.ladder.LadderGenerator;
import ladder.domain.ladder.simulator.DefaultLadderGameSimulator;
import ladder.domain.ladder.simulator.LadderGameSimulator;

public class LadderGameSetting {

  private final LadderGenerator ladderGenerator;
  private final LadderGameSimulator gameSimulator;

  private LadderGameSetting(LadderGenerator ladderGenerator, LadderGameSimulator gameSimulator) {
    this.ladderGenerator = ladderGenerator;
    this.gameSimulator = gameSimulator;
  }

  public static LadderGameSettingBuilder builder() {
    return new LadderGameSettingBuilder();
  }

  public static LadderGameSetting withDefaultSetting() {
    return new LadderGameSettingBuilder().build();
  }

  public Ladder generateLadderLine(int playerCnt, int ladderHeight) {
    return ladderGenerator.generateLadderLines(playerCnt, ladderHeight);
  }

  public LadderGameSimulator getGameSimulator() {
    return gameSimulator;
  }

  public static class LadderGameSettingBuilder {
    private LadderGenerator ladderGenerator;
    private LadderGameSimulator gameSimulator;


    public LadderGameSettingBuilder ladderGenerator(LadderGenerator ladderGenerator) {
      this.ladderGenerator = ladderGenerator;
      return this;
    }

    public LadderGameSettingBuilder gameSimulator(LadderGameSimulator gameSimulator) {
      this.gameSimulator = gameSimulator;
      return this;
    }

    private LadderGenerator getOrDefaultLadderGenerator() {
      if (this.ladderGenerator == null) {
        return new DefaultLadderGenerator();
      }
      return this.ladderGenerator;
    }

    private LadderGameSimulator getOrDefaultGameSimulator() {
      if (this.gameSimulator == null) {
        return new DefaultLadderGameSimulator();
      }
      return this.gameSimulator;
    }

    public LadderGameSetting build () {
      final LadderGenerator ladderGenerator = getOrDefaultLadderGenerator();
      final LadderGameSimulator gameSimulator = getOrDefaultGameSimulator();
      return new LadderGameSetting(ladderGenerator, gameSimulator);
    }
  }
}

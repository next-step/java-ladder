package ladder.domain.ladder.setting;

import java.util.List;
import ladder.domain.ladder.ladder.DefaultLadderGenerator;
import ladder.domain.ladder.ladder.Ladder;
import ladder.domain.ladder.ladder.LadderGenerator;
import ladder.domain.ladder.player.LadderGamePlayerInfo;
import ladder.domain.ladder.simulator.DefaultLadderGameSimulator;
import ladder.domain.ladder.simulator.LadderGameSimulator;
import ladder.domain.player.DefaultPlayerGenerator;
import ladder.domain.player.PlayerGenerator;

public class LadderGameSetting {

  private final PlayerGenerator playerGenerator;
  private final LadderGenerator ladderGenerator;
  private final LadderGameSimulator gameSimulator;

  private LadderGameSetting(PlayerGenerator playerGenerator, LadderGenerator ladderGenerator, LadderGameSimulator gameSimulator) {
    this.playerGenerator = playerGenerator;
    this.ladderGenerator = ladderGenerator;
    this.gameSimulator = gameSimulator;
  }

  public static LadderGameSettingBuilder builder() {
    return new LadderGameSettingBuilder();
  }

  public static LadderGameSetting withDefaultSetting() {
    return new LadderGameSettingBuilder().build();
  }


  public LadderGamePlayerInfo generatePlayer(List<String> playerNames) {
    return playerGenerator.generatePlayerList(playerNames);
  }

  public Ladder generateLadderLine(int playerCnt, int ladderHeight) {
    return ladderGenerator.generateLadderLines(playerCnt, ladderHeight);
  }

  public LadderGameSimulator getGameSimulator() {
    return gameSimulator;
  }

  public static class LadderGameSettingBuilder {

    private PlayerGenerator playerGenerator;
    private LadderGenerator ladderGenerator;
    private LadderGameSimulator gameSimulator;

    public LadderGameSettingBuilder playerGenerator(PlayerGenerator playerGenerator) {
      this.playerGenerator = playerGenerator;
      return this;
    }

    public LadderGameSettingBuilder ladderGenerator(LadderGenerator ladderGenerator) {
      this.ladderGenerator = ladderGenerator;
      return this;
    }

    public LadderGameSettingBuilder gameSimulator(LadderGameSimulator gameSimulator) {
      this.gameSimulator = gameSimulator;
      return this;
    }

    private PlayerGenerator getOrDefaultPlayerGenerator() {
      if (this.playerGenerator == null) {
        return new DefaultPlayerGenerator();
      }
      return this.playerGenerator;
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
      final PlayerGenerator playerGenerator = getOrDefaultPlayerGenerator();
      final LadderGenerator ladderGenerator = getOrDefaultLadderGenerator();
      final LadderGameSimulator gameSimulator = getOrDefaultGameSimulator();
      return new LadderGameSetting(playerGenerator, ladderGenerator, gameSimulator);
    }
  }
}

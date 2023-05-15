package ladder.domain.ladder.setting;

import java.util.List;
import ladder.domain.Line.Line;
import ladder.domain.ladder.DefaultLadderGenerator;
import ladder.domain.ladder.LadderGenerator;
import ladder.domain.player.DefaultPlayerGenerator;
import ladder.domain.player.Player;
import ladder.domain.player.PlayerGenerator;

public class LadderGameSetting {

  private final PlayerGenerator playerGenerator;
  private final LadderGenerator ladderGenerator;

  private LadderGameSetting(PlayerGenerator playerGenerator, LadderGenerator ladderGenerator) {
    this.playerGenerator = playerGenerator;
    this.ladderGenerator = ladderGenerator;
  }

  public static LadderGameSettingBuilder builder() {
    return new LadderGameSettingBuilder();
  }

  public List<Player> generatePlayer(List<String> playerNames) {
    return playerGenerator.generatePlayerList(playerNames);
  }

  public List<Line> generateLadderLine(int playerCnt, int ladderHeight) {
    return ladderGenerator.generateLadderLines(playerCnt, ladderHeight);
  }

  public static class LadderGameSettingBuilder {

    private PlayerGenerator playerGenerator;
    private LadderGenerator ladderGenerator;

    public LadderGameSettingBuilder playerGenerator(PlayerGenerator playerGenerator) {
      this.playerGenerator = playerGenerator;
      return this;
    }

    public LadderGameSettingBuilder ladderGenerator(LadderGenerator ladderGenerator) {
      this.ladderGenerator = ladderGenerator;
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

    public LadderGameSetting build () {
      PlayerGenerator playerGenerator = getOrDefaultPlayerGenerator();
      LadderGenerator ladderGenerator = getOrDefaultLadderGenerator();
      return new LadderGameSetting(playerGenerator, ladderGenerator);
    }
  }
}

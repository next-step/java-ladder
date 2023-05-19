package ladder.domain.ladder.setting;

import java.util.List;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.DefaultLadderGenerator;
import ladder.domain.ladder.LadderGenerator;
import ladder.domain.ladder.player.LadderGamePlayerInfo;
import ladder.domain.ladder.reword.DefaultRewordGenerator;
import ladder.domain.ladder.reword.LadderGameRewordInfo;
import ladder.domain.ladder.reword.RewordGenerator;
import ladder.domain.player.DefaultPlayerGenerator;
import ladder.domain.player.PlayerGenerator;

public class LadderGameSetting {

  private final PlayerGenerator playerGenerator;
  private final LadderGenerator ladderGenerator;

  private final RewordGenerator rewordGenerator;

  private LadderGameSetting(PlayerGenerator playerGenerator, LadderGenerator ladderGenerator, RewordGenerator rewordGenerator) {
    this.playerGenerator = playerGenerator;
    this.ladderGenerator = ladderGenerator;
    this.rewordGenerator = rewordGenerator;
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

  public LadderGameRewordInfo generateReword(List<String> rewords) {
    return rewordGenerator.generateReword(rewords);
  }

  public static class LadderGameSettingBuilder {

    private PlayerGenerator playerGenerator;
    private LadderGenerator ladderGenerator;
    private RewordGenerator rewordGenerator;

    public LadderGameSettingBuilder playerGenerator(PlayerGenerator playerGenerator) {
      this.playerGenerator = playerGenerator;
      return this;
    }

    public LadderGameSettingBuilder ladderGenerator(LadderGenerator ladderGenerator) {
      this.ladderGenerator = ladderGenerator;
      return this;
    }

    public LadderGameSettingBuilder rewordGenerator(RewordGenerator rewordGenerator) {
      this.rewordGenerator = rewordGenerator;
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

    private RewordGenerator getOrDefaultRewordGenerator() {
      if (this.rewordGenerator == null) {
        return new DefaultRewordGenerator();
      }
      return this.rewordGenerator;
    }

    public LadderGameSetting build () {
      final PlayerGenerator playerGenerator = getOrDefaultPlayerGenerator();
      final LadderGenerator ladderGenerator = getOrDefaultLadderGenerator();
      final RewordGenerator rewordGenerator = getOrDefaultRewordGenerator();
      return new LadderGameSetting(playerGenerator, ladderGenerator, rewordGenerator);
    }
  }
}

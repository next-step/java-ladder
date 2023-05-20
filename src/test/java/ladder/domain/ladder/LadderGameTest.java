package ladder.domain.ladder;

import config.BaseTest;
import java.util.Arrays;
import java.util.List;
import ladder.domain.ladder.player.LadderGamePlayerInfo;
import ladder.domain.ladder.reword.LadderGameReword;
import ladder.domain.ladder.reword.LadderGameRewordInfo;
import ladder.domain.ladder.setting.LadderGameSetting;
import ladder.domain.player.DefaultPlayerGenerator;
import ladder.domain.player.PlayerGenerator;
import ladder.domain.result.LadderGameResult;
import ladder.testDouble.NextStepExampleFixedLadderGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest extends BaseTest {

  int 사다리_높이;
  LadderGameSetting gameSetting;
  PlayerGenerator playerGenerator;
  LadderGameRewordInfo 게임_보상_기본;

  @BeforeEach
  void test() {
    사다리_높이 = 5;
    게임_보상_기본 = new LadderGameRewordInfo(List.of("꽝", "5000", "꽝", "3000"));
    gameSetting = LadderGameSetting.withDefaultSetting();
    playerGenerator = new DefaultPlayerGenerator();
  }

  @Test
  @DisplayName("LadderGame.play() | 사다리 게임 종료 후 모든 플레이어의 사다리 높이는 설정한 사다리 높이와 동일하다")
  void 게임_종료_후_사다리_높이와_플레이어의_높이는_동일() {
    // given
    List<String> 플레이어_이름_목록 = Arrays.asList("a","b", "c", "d");
    LadderGamePlayerInfo 플레이어_정보 = playerGenerator.generatePlayerList(플레이어_이름_목록);

    gameSetting = LadderGameSetting.builder()
        .ladderGenerator(new NextStepExampleFixedLadderGenerator())
        .build();

    LadderGame ladderGame = new LadderGame(플레이어_이름_목록.size(), 사다리_높이, gameSetting);

    // when
    ladderGame.play(플레이어_정보, 게임_보상_기본);

    // then
    Assertions.assertThat(플레이어_정보.getPlayers())
        .allMatch(player -> player.getCurrentHeight() == 사다리_높이);
  }

  @Test
  @DisplayName("LadderGame.play() | 넥스트 스텝 예시) 사다리 게임을 넥스트 스텝의 예제와 동일하게 진행하고, 결과를 비교한다.")
  void 사다리_게임_넥스트스텝_예시() {
    /*
      pobi : 꽝
      honux : 3000
      crong : 꽝
      jk : 5000
    */

    // given
    List<String> 플레이어_이름_목록 = Arrays.asList("pobi","honux", "crong", "jk");
    LadderGamePlayerInfo 플레이어_정보 = playerGenerator.generatePlayerList(플레이어_이름_목록);

    gameSetting = LadderGameSetting.builder()
        .ladderGenerator(new NextStepExampleFixedLadderGenerator())
        .build();

    LadderGame ladderGame = new LadderGame(플레이어_이름_목록.size(), 사다리_높이, gameSetting);

    // when
    LadderGameResult result = ladderGame.play(플레이어_정보, 게임_보상_기본);

    // then
    var mapAssert = Assertions.assertThat(result.getPlayerResultMap());
    mapAssert.extractingByKey("pobi").extracting("reword").isEqualTo(new LadderGameReword(0));
    mapAssert.extractingByKey("honux").extracting("reword").isEqualTo(new LadderGameReword(3000));
    mapAssert.extractingByKey("crong").extracting("reword").isEqualTo(new LadderGameReword(0));
    mapAssert.extractingByKey("jk").extracting("reword").isEqualTo(new LadderGameReword(5000));
  }
}

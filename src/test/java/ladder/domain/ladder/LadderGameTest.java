package ladder.domain.ladder;

import config.BaseTest;
import exception.ExceptionCode;
import java.util.Arrays;
import java.util.List;
import ladder.domain.ladder.ladder.Ladder;
import ladder.domain.ladder.reword.LadderGameReword;
import ladder.domain.ladder.setting.LadderGameSetting;
import ladder.domain.result.LadderGameResult;
import ladder.testDouble.NextStepExampleFixedLadderGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest extends BaseTest {

  int 사다리_높이;
  LadderGameSetting gameSetting;

  List<String> 기본_게임_보상_목록;

  @BeforeEach
  void test() {
    사다리_높이 = 5;
    gameSetting = LadderGameSetting.withDefaultSetting();
    기본_게임_보상_목록 = List.of("꽝", "5000", "꽝", "3000");
  }

  @Test
  @DisplayName("LadderGame | 플레이어목록에 동일한 이름이 있는 경우, 게임을 시작 할 수 없다.")
  void 사다리게임의_높이만큼_라인이_생성된다() {
    // given
    List<String> 플레이어_이름_목록 = Arrays.asList("s1", "s2", "seol");
    LadderGame ladderGame = new LadderGame(플레이어_이름_목록, 기본_게임_보상_목록, 사다리_높이, gameSetting);

    // when
    Ladder ladder = ladderGame.getLadder();

    // then
    Assertions.assertThat(ladder.getLadderHeight())
        .isEqualTo(사다리_높이);
  }

  @Test
  @DisplayName("LadderGame | 플레이어목록에 동일한 이름이 있는 경우, 게임을 시작 할 수 없다.")
  void 사다리게임에_참가한_플레이어_이름이_고유해야한다() {
    // given
    List<String> 플레이어_이름_목록 = Arrays.asList("sight", "sight", "seol");

    // when & then
    super.assertThatThrowsLadderGameException(
        () -> new LadderGame(플레이어_이름_목록, 기본_게임_보상_목록, 사다리_높이, gameSetting),
        ExceptionCode.DUPLICATE_PLAYER_IN_GAME
    );
  }

  @Test
  @DisplayName("LadderGame | 사다리게임에 참가한 플레이어는 최소 두명 이상이어야한다")
  void 사다리게임에_참가한_플레이어는_최소_두명_이상이어야한다() {
    // given
    List<String> 플레이어_이름_목록 = Arrays.asList("sight");

    // when & then
    super.assertThatThrowsLadderGameException(
        () -> new LadderGame(플레이어_이름_목록, 기본_게임_보상_목록, 사다리_높이, gameSetting),
        ExceptionCode.MIN_PLAYER_COUNT_REQUIRED
    );
  }

  @Test
  @DisplayName("LadderGame.play | 사다리 게임이 끝나면 모든 플레이어의 사다리 높이는 설정한 사다리 높이 + 1을 가진다 (결과까지)")
  void 게임_종료_후_사다리_높이와_플레이어의_높이는_동일() {
    // given
    List<String> 플레이어_이름_목록 = Arrays.asList("a","b", "c", "d");

    gameSetting = LadderGameSetting.builder()
        .ladderGenerator(new NextStepExampleFixedLadderGenerator())
        .build();

    LadderGame ladderGame = new LadderGame(플레이어_이름_목록, 기본_게임_보상_목록, 사다리_높이, gameSetting);

    // when
    ladderGame.play();

    // then
    Assertions.assertThat(ladderGame.getPlayerInfo().getPlayers())
        .allMatch(player -> player.getCurrentHeight() == 사다리_높이);
  }

  @Test
  @DisplayName("LadderGame.play | 넥스트 스텝 예시) 사다리 게임을 넥스트 스텝의 예제와 동일하게 진행하고, 결과를 비교한다.")
  void 사다리_게임_넥스트스텝_예시() {
    /*
      pobi : 꽝
      honux : 3000
      crong : 꽝
      jk : 5000
    */

    // given
    List<String> 플레이어_이름_목록 = Arrays.asList("pobi","honux", "crong", "jk");

    gameSetting = LadderGameSetting.builder()
        .ladderGenerator(new NextStepExampleFixedLadderGenerator())
        .build();

    LadderGame ladderGame = new LadderGame(플레이어_이름_목록, 기본_게임_보상_목록, 사다리_높이, gameSetting);

    // when
    LadderGameResult result = ladderGame.play();

    // then
    var mapAssert = Assertions.assertThat(result.getPlayerResultMap());
    mapAssert.extractingByKey("pobi").extracting("reword").isEqualTo(new LadderGameReword(0));
    mapAssert.extractingByKey("honux").extracting("reword").isEqualTo(new LadderGameReword(3000));
    mapAssert.extractingByKey("crong").extracting("reword").isEqualTo(new LadderGameReword(0));
    mapAssert.extractingByKey("jk").extracting("reword").isEqualTo(new LadderGameReword(5000));
  }
}

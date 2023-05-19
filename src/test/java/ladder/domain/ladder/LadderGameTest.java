package ladder.domain.ladder;

import config.BaseTest;
import exception.ExceptionCode;
import java.util.Arrays;
import java.util.List;
import ladder.domain.LadderGame;
import ladder.domain.ladder.setting.LadderGameSetting;
import ladder.domain.player.DefaultPlayerGenerator;
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

    // when & then
    LadderGame ladderGame = new LadderGame(플레이어_이름_목록, 기본_게임_보상_목록, 사다리_높이, gameSetting);

    Assertions.assertThat(ladderGame.getLadderLineSize())
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
  @DisplayName("LadderGame | 사다리게임의 사다리 높이는 최소 1 이상이어야한다.")
  void 사다리게임의_사다리_높이는_최소_1_이상이어야한다() {
    // given
    List<String> 플레이어_이름_목록 = Arrays.asList("sight", "seol");

    // when & then
    super.assertThatThrowsLadderGameException(
        () -> new LadderGame(플레이어_이름_목록, 기본_게임_보상_목록, 0, gameSetting),
        ExceptionCode.MIN_LADDER_HEIGHT_REQUIRED
    );
  }
}

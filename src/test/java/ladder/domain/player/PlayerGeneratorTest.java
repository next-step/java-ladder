package ladder.domain.player;

import config.BaseTest;
import exception.ExceptionCode;
import java.util.Arrays;
import java.util.List;
import ladder.domain.LadderGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerGeneratorTest extends BaseTest {

  int 사다리_높이;
  @BeforeEach
  void test() {
    사다리_높이 = 5;
  }

  @Test
  @DisplayName("LadderPlayerGenerator | 플레이어목록에 동일한 이름이 있는 경우, 게임을 시작 할 수 없다.")
  void 사다리게임에_참가한_플레이어_이름이_고유해야한다() {
    // given
    List<String> 플레이어_이름_목록 = Arrays.asList("sight", "sight", "seol");

    // when & then
    super.assertThatThrowsLadderGameException(
        () -> new LadderGame(플레이어_이름_목록, 사다리_높이),
        ExceptionCode.DUPLICATE_PLAYER_IN_GAME
    );
  }
}

package ladder.domain.ladder.reword;

import config.BaseTest;
import exception.ExceptionCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameRewordTest extends BaseTest {

  @Test
  @DisplayName("LadderGameReword | 사다리게임 보상에서 0보다 작을 수 없다.")
  void 사다리_게임의_보상은_0보다_작을_수_없다() {
    // given
    int invalidPrize = -1;

    // when & then
    super.assertThatThrowsLadderGameException(
        () -> new LadderGameReword(-1),
        ExceptionCode.REWORD_MUST_POSITIVE_ZERO
    );
  }
}

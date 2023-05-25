package ladder.domain.ladder.line;

import config.BaseTest;
import exception.ExceptionCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HorizontalLadderLineTest extends BaseTest {

  @Test
  @DisplayName("사다리는 한 라인에 포인트를 연속해서 이을 수 없다.")
  void 사다리_라인에서_연속해서_포인트를_이을_수_없음() {
    // given
    HorizontalLadderLine line = new HorizontalLadderLine(10);
    line.connect(0, 1);

    // when & then
    super.assertThatThrowsLadderGameException(
        () -> line.connect(1, 2),
        ExceptionCode.CANNOT_CONNECT_CONTINUOUS_POINT
    );
  }

  @Test
  @DisplayName("사다리 라인에서 존재하지 않는 포인트는 가져올 수 없다")
  void 사다리_라인에서_존재하지_않는_포인트는_가져올_수_없다() {
    // given
    HorizontalLadderLine line = new HorizontalLadderLine(10);

    // when & then
    super.assertThatThrowsLadderGameException(
        () -> line.getPointAt(11),
        ExceptionCode.LINE_POINT_NOT_FOUND
    );
  }
}

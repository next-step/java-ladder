package ladder.domain.line;

import config.BaseTest;
import exception.ExceptionCode;
import ladder.domain.Line.Line;
import ladder.domain.Line.LinePoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest extends BaseTest {

  @Test
  @DisplayName("Line.connect() | 사다리는 한 라인에 포인트를 연속해서 이을 수 없다.")
  void 사다리_라인에서_연속해서_포인트를_이을_수_없음() {
    // given
    Line line = new Line(10);
    line.connect(0, 1);

    // when & then
    super.assertThatThrowsLadderGameException(
        () -> line.connect(1, 2),
        ExceptionCode.CANNOT_CONNECT_CONTINUOUS_POINT
    );
  }

  @Test
  @DisplayName("Line.isConnected() | 사다리 라인에서 인접되지않은 포인트는 비교 할 수 없다")
  void 사다리_라인에서_인접되지않은_포인트는_비교_할_수_없다() {
    // given
    Line line = new Line(10);
    LinePoint point0 = line.getPoint(0);
    LinePoint point3 = line.getPoint(3);

    // when & then
    super.assertThatThrowsLadderGameException(
        () -> line.isConnected(point0, point3),
        ExceptionCode.CONNECTION_CHECKED_NOT_SUPPORTED
    );
  }

  @Test
  @DisplayName("Line.getPoint() | 사다리 라인에서 존재하지 않는 포인트는 가져올 수 없다")
  void 사다리_라인에서_존재하지_않는_포인트는_가져올_수_없다() {
    // given
    Line line = new Line(10);

    // when & then
    super.assertThatThrowsLadderGameException(
        () -> line.getPoint(11),
        ExceptionCode.LINE_POINT_NOT_FOUND
    );
  }
}

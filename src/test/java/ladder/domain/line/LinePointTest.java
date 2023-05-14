package ladder.domain.line;

import config.BaseTest;
import exception.ExceptionCode;
import java.util.List;
import ladder.domain.Line.LineGenerator;
import ladder.domain.Line.LinePoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinePointTest extends BaseTest {

  @Test
  @DisplayName("LinePoint.connect | 역방향으로는 연결 할 수 없다.")
  void 라인_포인트는_역방향으로_연결_할_수_없다() {

    // given
    LineGenerator lineGenerator = new LineGenerator();
    List<LinePoint> linePoints = lineGenerator.generateNotConnectedPoints(5);

    LinePoint linePoint1 = linePoints.get(0);
    LinePoint linePoint2 = linePoints.get(1);

    // when & then
    super.assertThatThrowsLadderGameException(
        () -> linePoint2.connect(linePoint1),
        ExceptionCode.CANNOT_CONNECT_POINT_IN_REVERSE_ORDER
    );
  }

}

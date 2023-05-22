package ladder.domain.line;

import config.BaseTest;
import ladder.domain.ladder.line.HorizontalLadderLine;
import ladder.domain.ladder.line.connector.BinaryRandomlyLadderLineConnector;
import ladder.domain.ladder.line.point.LinePoint;
import ladder.testDouble.random.FixedFalseOnlyRandomBooleanGenerator;
import ladder.testDouble.random.FixedTrueOnlyRandomBooleanGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinaryRandomlyLadderLineConnectorTest extends BaseTest {

  private BinaryRandomlyLadderLineConnector sut;

  @Test
  @DisplayName("LadderLineConnector | 랜덤으로 false 가 나온경우, 라인의 포인트들은 연결되지 않는다.")
  void 라인_연결_랜덤이_거짓인_경우() {
    // given
    sut = new BinaryRandomlyLadderLineConnector(new FixedFalseOnlyRandomBooleanGenerator());
    HorizontalLadderLine initLine = new HorizontalLadderLine(10);

    // when
    HorizontalLadderLine result = sut.connectNextPoint(initLine, 1);
    LinePoint pointAt = result.getPointAt(2);

    // then
    Assertions.assertThat(result.isPreviousPointConnected(pointAt)).isFalse();
  }

  @Test
  @DisplayName("LadderLineConnector | 랜덤으로 true 가 나온경우, 라인의 포인트들은 연결된다.")
  void 라인_연결_랜덤이_참인_경우() {
    // given
    sut = new BinaryRandomlyLadderLineConnector(new FixedTrueOnlyRandomBooleanGenerator());
    HorizontalLadderLine initLine = new HorizontalLadderLine(10);

    // when
    HorizontalLadderLine result = sut.connectNextPoint(initLine, 1);
    LinePoint pointAt = result.getPointAt(2);

    // then
    Assertions.assertThat(result.isPreviousPointConnected(pointAt)).isTrue();
  }
}

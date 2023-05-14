package ladder.domain.ladder;

import config.BaseTest;
import exception.ExceptionCode;
import ladder.testDouble.LadderFirstLineTwoConnectedLineGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGeneratorTest extends BaseTest {

  private LadderGenerator ladderGenerator;

  @BeforeEach
  void setup() {
    ladderGenerator = new LadderFirstLineTwoConnectedLineGenerator();
  }


  @Test
  @DisplayName("LadderGenerator | 사다리에서 인접한 포인트들은 연속으로 이어서 생성 할 수 없다.")
  void test() {
    // given
    LadderGenerator ladderGenerator = new LadderFirstLineTwoConnectedLineGenerator();

//    // when && then
//    super.assertThatThrowsLadderGameException(
//        () -> ladderGenerator.generateLadderLines(5, 5),
//        ExceptionCode.CANNOT_CONNECT_POINT
//    );
  }
}

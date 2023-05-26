package ladder.domain.ladder;

import config.BaseTest;
import exception.ExceptionCode;
import ladder.domain.ladder.ladder.Ladder;
import ladder.domain.ladder.ladder.LadderGenerator;
import ladder.domain.ladder.line.point.LinePoint;
import ladder.testDouble.ladder.NotConnectedLadderGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest extends BaseTest {

  LadderGenerator ladderGenerator;

  @BeforeEach
  void setup() {
    ladderGenerator = new NotConnectedLadderGenerator();
  }

  @Test
  @DisplayName("사다리는 한번 생성이 완료되면, 추가로 연결 할 수 없다.")
  void 사다리_생성_후_연결불가() {

    // given
    int 플레이어_수 = 10;
    int 사다리_높이 = 5;

    Ladder ladder = ladderGenerator.generateLadderLines(플레이어_수, 사다리_높이);

    LinePoint pointFrom = ladder.getPointAt(1, 1);
    LinePoint pointTo = ladder.getPointAt(1, 2);

    // when && then
    super.assertThatThrowsLadderGameException(
        () -> pointFrom.connect(pointTo),
        ExceptionCode.CANNOT_MODIFY_LADDER_AFTER_CREATED
    );
  }
}

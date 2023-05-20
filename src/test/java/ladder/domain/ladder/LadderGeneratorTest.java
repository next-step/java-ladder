package ladder.domain.ladder;

import config.BaseTest;
import exception.ExceptionCode;
import ladder.domain.ladder.ladder.DefaultLadderGenerator;
import ladder.domain.ladder.ladder.LadderGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGeneratorTest extends BaseTest {

  private LadderGenerator sut;

  @BeforeEach
  void setup() {
    this.sut = new DefaultLadderGenerator();
  }

  @Test
  @DisplayName("LadderGenerator | 사다리게임의 사다리 높이는 최소 1 이상이어야한다.")
  void 사다리게임의_사다리_높이는_최소_1_이상이어야한다() {
    // given
    int playerCount = 10;
    int ladderHeight = 0;

    // when & then
    super.assertThatThrowsLadderGameException(
        () -> sut.generateLadderLines(playerCount, ladderHeight),
        ExceptionCode.MIN_LADDER_HEIGHT_REQUIRED
    );
  }
}

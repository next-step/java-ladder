package ladder.domain.ladder;

import config.BaseTest;
import exception.ExceptionCode;
import java.util.Arrays;
import java.util.List;
import ladder.domain.ladder.ladder.DefaultLadderGenerator;
import ladder.domain.ladder.ladder.Ladder;
import ladder.domain.ladder.ladder.LadderGenerator;
import org.assertj.core.api.Assertions;
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
  @DisplayName("사다리게임의 사다리 높이는 최소 1 이상이어야한다.")
  void 사다리게임의_사다리_높이는_최소_1_이상이어야한다() {
    // given
    List<String> 플레이어_이름_목록 = Arrays.asList("s1");
    int 사다리_높이 = 0;

    // when & then
    super.assertThatThrowsLadderGameException(
        () -> sut.generateLadderLines(플레이어_이름_목록.size(), 사다리_높이),
        ExceptionCode.MIN_LADDER_HEIGHT_REQUIRED
    );
  }

  @Test
  @DisplayName("사다리게임의 높이만큼 라인이 생성된다")
  void 사다리게임의_높이만큼_라인이_생성된다() {
    // given
    List<String> 플레이어_이름_목록 = Arrays.asList("s1", "s2", "seol");
    int 사다리_높이 = 5;

    // when
    Ladder ladder = sut.generateLadderLines(플레이어_이름_목록.size(), 사다리_높이);

    // then
    Assertions.assertThat(ladder.getLadderHeight())
        .isEqualTo(사다리_높이);
  }
}

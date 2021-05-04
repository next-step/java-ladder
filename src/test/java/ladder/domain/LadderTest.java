package ladder.domain;

import ladder.exception.LadderHeightOutOfBoundsException;
import ladder.exception.LadderWidthOutOfBoundsException;
import ladder.rule.LineRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {

  @RepeatedTest(1_000)
  @DisplayName("높이와 폭에 맡게 사다리를 생성한다.")
  void generate() {
    // given
    int height = get10LessThenRandomNumber();
    int width = get10LessThenRandomNumber();

    // when
    Ladder ladder = Ladder.generate(height, width, LineRule.random());

    // then
    assertAll(
            () -> assertThat(ladder.height()).isEqualTo(height),
            () -> assertThat(ladder.width()).isEqualTo(width)
    );
  }

  @Test
  @DisplayName("최소 높이와 폭은 1 이상이어야 한다.")
  void generate_error() {
    assertAll(
            () -> assertThatExceptionOfType(LadderHeightOutOfBoundsException.class)
                    .isThrownBy(() -> Ladder.generate(Ladder.MIN_OF_HEIGHT - 1, Ladder.MIN_OF_WIDTH, LineRule.random()))
                    .withMessageMatching("사다리의 최소 높이는 \\d+ 입니다."),
            () -> assertThatExceptionOfType(LadderWidthOutOfBoundsException.class)
                    .isThrownBy(() -> Ladder.generate(Ladder.MIN_OF_HEIGHT, Ladder.MIN_OF_WIDTH - 1, LineRule.random()))
                    .withMessageMatching("사다리의 최소 폭은 \\d+ 입니다.")
    );
  }

  @Test
  @DisplayName("사다리 마지막 깊이의 시작 지점(위치)를 추출한다.")
  void getLastDepthStartLinePosition() {
    // given
    int width = 2;

    // when
    Ladder actual = Ladder.generate(Ladder.MIN_OF_HEIGHT, width, LineRule.drawing());

    // then
    assertAll(
            () -> assertThat(actual.getLastDepthStartLinePosition(0)).isEqualTo(new Position(1)),
            () -> assertThat(actual.getLastDepthStartLinePosition(1)).isEqualTo(new Position(0))
    );
  }

  private int get10LessThenRandomNumber() {
    return new Random().nextInt(10) + 1;
  }
}
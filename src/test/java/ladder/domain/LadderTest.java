package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

  @RepeatedTest(1_000)
  @DisplayName("높이와 폭에 맡게 사다리를 생성한다.")
  void generate() {
    // given
    int height = get10LessThenRandomNumber();
    int width = get10LessThenRandomNumber();

    // when
    Ladder ladder = Ladder.generate(height, width);
    System.out.println(ladder);
    // then
    assertThat(ladder.height()).isEqualTo(height);
    assertThat(ladder.width()).isEqualTo(width);
  }

  @Test
  @DisplayName("최소 높이와 폭은 1 이상이어야 한다.")
  void generate_error() {
    assertThatThrownBy(() -> Ladder.generate(0, 0))
            .isInstanceOf(IllegalArgumentException.class);
  }

  private int get10LessThenRandomNumber() {
    return new Random().nextInt(10) + 1;
  }
}
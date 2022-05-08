package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

  @DisplayName("입력한 너비와 높이를 갖는 사다리를 생성할 수 있다.")
  @Test
  void create_성공() {
    Ladder ladder = Ladder.of(10, 20);
    assertThat(ladder.getWidth()).isEqualTo(10);
    assertThat(ladder.getHeight()).isEqualTo(20);
  }

  @DisplayName("1보다 작은 너비나 높이가 입력되면 예외가 발생한다.")
  @Test
  void create_실패() {
    assertThatThrownBy(() -> Ladder.of(0, 0))
        .isInstanceOf(IllegalArgumentException.class);
  }
}

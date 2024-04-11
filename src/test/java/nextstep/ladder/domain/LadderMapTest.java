package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderMapTest {

  @Test
  @DisplayName("사다리 너비가 1 미만일 경우 예외 발생")
  void validateWidth() {
    int width = 0;
    int height = 5;

     assertThatThrownBy(() -> new LadderMap(width, height))
         .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("사다리 높이가 1 미만일 경우 예외 발생")
  void validateHeight() {
    int width = 3;
    int height = 0;

    assertThatThrownBy(() -> new LadderMap(width, height))
        .isInstanceOf(IllegalArgumentException.class);
  }
}

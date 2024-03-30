package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
  @Test
  void 이름은_최대_5글자() {
    Assertions.assertThatThrownBy(() -> Player.of("abcdef"))
            .isInstanceOf(IllegalArgumentException.class);
  }
}

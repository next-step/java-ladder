package ladder.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class LadderHeightTest {

  @Test
  void 생성() {
    assertThat(LadderHeight.of(3)).isEqualTo(LadderHeight.of(3));
  }

  @Test
  void 높이는_0보다_커야한다() {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      LadderHeight.of(0);
    });
  }
}

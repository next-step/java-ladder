package ladder.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class PositionTest {

  @Test
  void 생성() {
    Position position = new Position(1);
    assertThat(position).isEqualTo(new Position(1));
  }

  @Test
  void 음수값테스트() {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Position(-1);
    });
  }

  @Test
  void 증가테스트() {
    assertThat(new Position(0).increment()).isEqualTo(new Position(1));
  }

  @Test
  void 감소테스트() {
    assertThat(new Position(5).decrease()).isEqualTo(new Position(4));
  }
}

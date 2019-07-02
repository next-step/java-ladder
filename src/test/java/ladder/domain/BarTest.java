package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BarTest {

  @DisplayName("bar 생성 테스트")
  @Test
  void create() {
    Bar bar = Bar.of(true);
    assertThat(bar.isBar()).isTrue();
  }

}

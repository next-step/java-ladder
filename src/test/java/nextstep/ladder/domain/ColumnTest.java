package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ColumnTest {

  @Test
  void constructor_pass() {
    new Column(1, 3);
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, 3, 5})
  void constructor_fail(int column) {
    Assertions.assertThatThrownBy(() -> new Column(column, 3))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
package nextstep.ladder.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RowTest {

  @Test
  void constructor_pass() {
    new Row(1, 3);
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, 5})
  void constructor_fail(int row) {
    Assertions.assertThatThrownBy(() -> new Row(row, 3))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
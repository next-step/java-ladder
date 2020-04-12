package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.ladder.model.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

  @DisplayName("Test for name that exceeds the length")
  @Test
  public void testLongName() {
    assertThatThrownBy(() -> new Name("abcdef"))
        .isInstanceOf(IllegalArgumentException.class);
  }
}

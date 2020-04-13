package nextstep.ladder.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

  @DisplayName("Test for name that exceeds the length")
  @Test
  public void testLongName() {
    assertThatThrownBy(() -> new Name("abcdef"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("Test for equals methos")
  @Test
  public void testEquals() {
    assertThat(new Name("aya").equals(new Name("aya")));
  }
}

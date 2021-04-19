package nextstep.ladder.src;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class UserTest {

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("exception with empty or null")
  public void assureNotEmpty(String name) {
    assertThatThrownBy(() -> {
      new User(name);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("check max length")
  public void checkMaxLength() {
    assertThatThrownBy(() -> {
      new User("maxlen");
    }).isInstanceOf(IllegalArgumentException.class);
  }
}

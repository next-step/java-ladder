package ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import ladder.domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

  @Test
  @DisplayName("잘못된 형식의 이름인지")
  public void validateName() {
    assertThatThrownBy(() -> {
      Name name = new Name("asb#*s");
    }).isInstanceOf(IllegalArgumentException.class);

  }
}

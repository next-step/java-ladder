package ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import ladder.domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

  @Test
  @DisplayName("잘못된 형식의 이름 확인")
  public void validateName() {
    assertThatThrownBy(() -> {
      Name name = new Name("asb#*s");
    }).isInstanceOf(IllegalArgumentException.class);
  }


  @Test
  @DisplayName("5글자 초과 이름 확인")
  public void validateNameLength() {
    assertThatThrownBy(() -> {
      Name name = new Name("abababababa");
    }).isInstanceOf(IllegalArgumentException.class);
  }
}

package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

  @Test
  @DisplayName("[Name] 참가자 이름 객체 생성 테스트")
  void nameTest() {
    Name name = new Name("pobi");
    assertThat(name).isEqualTo(new Name("pobi"));
  }

  @Test
  @DisplayName("[Name] 이름 5자 초과 예외처리 테스트")
  void validateNameTest() {
    assertThatThrownBy(() -> new Name("abcdef"))
        .isInstanceOf(IllegalArgumentException.class);
  }
}

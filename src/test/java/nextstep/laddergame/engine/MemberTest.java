package nextstep.laddergame.engine;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberTest {

  @DisplayName("사람은 null 또는 비어있는 이름을 가질 수 없다.")
  @Test
  public void member_throwException_ifNullOrEmpty() {
    assertAll(
        () -> assertThatThrownBy(() -> new Member("")).isInstanceOf(IllegalArgumentException.class),
        () -> assertThatThrownBy(() -> new Member(null))
            .isInstanceOf(IllegalArgumentException.class)
    );
  }

  @DisplayName("사람은 최대 5글자까지 이름을 가질 수 있다.")
  @Test
  public void member_throwException_ifOver5Length() {
    assertAll(
        () -> assertThatThrownBy(() -> new Member("123456"))
            .isInstanceOf(IllegalArgumentException.class),
        () -> assertThatThrownBy(() -> new Member("1234567"))
            .isInstanceOf(IllegalArgumentException.class)
    );
  }
}

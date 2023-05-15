package nextstep.laddergame.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberTest {

  @DisplayName("사람은 null 또는 비어있는 이름을 가질 수 없다.")
  @Test
  public void member_throwException_ifNullOrEmpty() {
    assertThatThrownBy(() -> new Member("")).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> new Member(null)).isInstanceOf(IllegalArgumentException.class);
  }

}

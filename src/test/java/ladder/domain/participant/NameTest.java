package ladder.domain.participant;

import static org.assertj.core.api.Assertions.*;

import ladder.domain.participant.Name;
import org.junit.jupiter.api.Test;

class NameTest {

  @Test
  void 이름이_5자_이하인_경우는_정상적으로_객체_생성() {
    assertThatNoException().isThrownBy(() -> new Name("abcde"));
  }

  @Test
  void 이름이_5자_초과인_경우는_예외_발생() {
    assertThatThrownBy(() -> new Name("abcdef"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("이름은 5자 이하만 가능합니다.");
  }
}
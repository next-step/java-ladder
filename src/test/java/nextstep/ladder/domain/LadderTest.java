package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

  @Test
  @DisplayName("높이와 이름을 입력받아 사다리를 생성한다.")
  void create() {
    // given
    final String[] names = new String[]{"pobi", "crong", "honux", "jk"};
    final int height = 3;

    // when
    final Ladder ladder = new Ladder(height, names);

    // then
    assertThat(ladder).isEqualTo(new Ladder(height, names));
  }
}

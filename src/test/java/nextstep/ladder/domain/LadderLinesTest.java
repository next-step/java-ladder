package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLinesTest {

  @Test
  @DisplayName("높이와, 이름 목록을 받아서 생성한다.")
  void create() {
    // given
    final int height = 3;
    final String[] names = new String[]{"pobi", "crong", "honux", "jk"};

    // when
    final LadderLines ladderLines = new LadderLines(height, names);

    // then
    assertThat(ladderLines).isEqualTo(new LadderLines(height, names));
  }
}

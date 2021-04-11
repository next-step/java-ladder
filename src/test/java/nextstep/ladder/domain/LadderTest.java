package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

  @Test
  @DisplayName("높이와 이름을 입력받아 사다리를 생성한다.")
  void create() {
    // given
    final int height = 3;
    final LadderHeight ladderHeight = new LadderHeight(height);
    final String[] names = new String[]{"pobi", "crong", "honux", "jk"};
    final People people = People.from(names);

    // when
    final Ladder ladder = new Ladder(ladderHeight, people);

    // then
    assertAll(
        () -> assertThat(ladder).isEqualTo(new Ladder(ladderHeight, people)),
        () -> assertThat(ladder.lines()).hasSize(height)
    );
  }
}

package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLinesTest {

  final int height = 3;
  final LadderHeight ladderHeight = new LadderHeight(height);
  final People people = new People(new String[]{"pobi", "crong", "honux", "jk"});

  LadderLines ladderLines;

  @BeforeEach
  void setUp() {
    ladderLines = new LadderLines(ladderHeight, people.personCount());
  }

  @Test
  @DisplayName("높이와, 이름 목록을 받아서 생성한다.")
  void create() {
    assertThat(ladderLines).isEqualTo(new LadderLines(ladderHeight, people.personCount()));
  }

  @Test
  @DisplayName("Line 목록을 반환한다.")
  void lines() {
    // given
    // when
    final List<Line> lines = ladderLines.lines();

    // then
    assertThat(lines).hasSize(height);
  }
}

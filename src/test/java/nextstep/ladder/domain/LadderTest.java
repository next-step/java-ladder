package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

  final int height = 3;
  final LadderHeight ladderHeight = new LadderHeight(height);
  final People people = People.from(new String[]{"pobi", "crong", "honux", "jk"});

  LineCreationStrategy lineCreationStrategy;

  @BeforeEach
  void setUpLineCreationStrategy() {
    lineCreationStrategy = () -> false;
  }

  Ladder ladder;

  @BeforeEach
  void setUp() {
    ladder = new Ladder(people, ladderHeight);
  }

  @Test
  @DisplayName("높이와, 이름 목록을 받아서 생성한다.")
  void create() {
    assertThat(ladder).isEqualTo(new Ladder(people, ladderHeight));
  }

  @Test
  @DisplayName("Line 목록을 반환한다.")
  void lines() {
    // given
    // when
    final List<Line> lines = ladder.lines(lineCreationStrategy);

    // then
    assertThat(lines).hasSize(height);
  }
}

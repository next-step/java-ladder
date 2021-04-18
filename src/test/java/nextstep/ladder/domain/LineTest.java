package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

  LineCreationStrategy lineCreationStrategy;

  @BeforeEach
  void setUp() {
    lineCreationStrategy = () -> true;
  }

  @Test
  @DisplayName("사람의 수를 입력받아서 Line을 생성한다.")
  void create() {
    assertThat(new Line(lineCreationStrategy, 2)).isEqualTo(new Line(lineCreationStrategy, 2));
  }

  @Test
  @DisplayName("다음 Point의 인덱스를 반환한다.")
  void nextPointIndex() {
    // given
    final int startIndex = 0;
    final Line line = new Line(lineCreationStrategy, 2);

    // when
    final int nextPointIndex = line.nextPointIndex(startIndex);

    // then
    assertThat(nextPointIndex).isNotEqualTo(startIndex);
  }
}

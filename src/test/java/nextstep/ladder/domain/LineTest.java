package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

  LineCreationStrategy lineCreationStrategy;

  @BeforeEach
  void setUp() {
    lineCreationStrategy = () -> false;
  }

  @Test
  @DisplayName("사람의 수를 입력받아서 Line을 생성한다.")
  void create() {
    assertThat(new Line(lineCreationStrategy, 2)).isEqualTo(new Line(lineCreationStrategy, 2));
  }
}

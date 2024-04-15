package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

  @Test
  @DisplayName("사다리를 생성한다.")
  void createLine() {
    int width = 5;
    Line line = new Line(width, new RandomBooleanGenerator());
    assertThat(line.getPoints().size()).isEqualTo(width);

  }

}

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

  @Test
  @DisplayName("사다리를 생성하고 한 줄을 이동한다.")
  void moveLine() {
    BooleanGenerator noBridgeGenerator = () -> false;

    Line line = new Line(5, noBridgeGenerator);
    assertThat(line.move(0)).isEqualTo(0);
    assertThat(line.move(1)).isEqualTo(1);
    assertThat(line.move(2)).isEqualTo(2);
    assertThat(line.move(3)).isEqualTo(3);
    assertThat(line.move(4)).isEqualTo(4);
  }

}

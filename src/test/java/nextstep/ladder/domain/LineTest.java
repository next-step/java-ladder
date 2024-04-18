package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder.domain.dimension.Line;
import nextstep.ladder.domain.generator.BooleanGenerator;
import nextstep.ladder.domain.generator.RandomBooleanGenerator;
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

  @Test
  @DisplayName("사다리에서 오른쪽으로 이동한다.")
  void moveRight() {
    Line line = new Line(5, () -> true);
    assertThat(line.move(0)).isEqualTo(1);
  }

  @Test
  @DisplayName("사다리 제일 끝에서 왼쪽으로 한칸 이동한다.")
  void moveLeft() {
    int width = 5;
    Line line = new Line(width, () -> true);
    assertThat(line.move(width)).isEqualTo(width-1);
  }

}

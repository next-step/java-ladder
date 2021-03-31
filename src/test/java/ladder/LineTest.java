package ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

  @Test
  @DisplayName("Line 생성 후 point 사이즈 확인")
  public void create() {
    Line line = new Line(4);
    assertThat(line.size()).isEqualTo(4);
  }

}

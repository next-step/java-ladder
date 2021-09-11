package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LineTest {

  @Test
  void createTest() {
    //given
    List<Boolean> points = Arrays.asList(false, true, false, true, false);

    //when
    Line line = new Line(points);

    //then
    assertThat(line.points()).isEqualTo(points);
  }

  @Test
  void invalidCreateTest() {
    //given
    List<Boolean> points1 = Arrays.asList(true, false, false, true, false);  // 처음부터 발판 존재
    List<Boolean> points2 = Arrays.asList(false, false, true, true, false);  // 연속된 발판

    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Line(points1);
    });
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Line(points2);
    });
  }
}
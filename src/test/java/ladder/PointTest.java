package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PointTest {

  @Test
  public void 생성테스트() {
    Point point = new Point(Direction.STRAIGHT);
  }

  @Test
  public void 포인트가_라인을_가지고있는지_확인한다() {
    assertThat(new Point(Direction.STRAIGHT).hasLine()).isEqualTo(false);
    assertThat(new Point(Direction.LEFT).hasLine()).isEqualTo(false);
    assertThat(new Point(Direction.RIGHT).hasLine()).isEqualTo(true);
  }

}

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

  @Test
  public void drawTest() {
    Point rightPoint = new Point(Direction.RIGHT);
    Point leftPoint = new Point(Direction.LEFT);
    Point straightPoint = new Point(Direction.STRAIGHT);

    assertThat(rightPoint.draw()).isEqualTo("|-----");
    assertThat(leftPoint.draw()).isEqualTo("|     ");
    assertThat(straightPoint.draw()).isEqualTo("|     ");
  }

  @Test
  public void moveTest() {
    int position = 3;
    assertThat(new Point(Direction.STRAIGHT).move(position)).isEqualTo(3);
    assertThat(new Point(Direction.RIGHT).move(position)).isEqualTo(4);
    assertThat(new Point(Direction.LEFT).move(position)).isEqualTo(2);
  }

}

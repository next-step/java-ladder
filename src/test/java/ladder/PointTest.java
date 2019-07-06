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
  public void 방향이_RIGHT일때_draw_테스트() {
    Point rightPoint = new Point(Direction.RIGHT);

    assertThat(rightPoint.draw()).isEqualTo("|-----");
  }

  @Test
  public void 방향이_LEFT일때_draw_테스트() {
    Point leftPoint = new Point(Direction.LEFT);

    assertThat(leftPoint.draw()).isEqualTo("|     ");
  }

  @Test
  public void 방향이_STRAIGHT일때_draw_테스트() {
    Point straightPoint = new Point(Direction.STRAIGHT);

    assertThat(straightPoint.draw()).isEqualTo("|     ");
  }

  @Test
  public void moveLeftTest() {
    int position = 3;
    assertThat(new Point(Direction.LEFT).move(position)).isEqualTo(2);
  }

  @Test
  public void moveRightTest() {
    int position = 3;
    assertThat(new Point(Direction.RIGHT).move(position)).isEqualTo(4);
  }

  @Test
  public void moveStraightTest() {
    int position = 3;
    assertThat(new Point(Direction.STRAIGHT).move(position)).isEqualTo(3);
  }

}

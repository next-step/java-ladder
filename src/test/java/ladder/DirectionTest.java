package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class DirectionTest {

  @Test
  public void STRAIGHT와LEFT는_라인이없고_RIGHT만_라인이있다() {
    assertThat(Direction.STRAIGHT.hasLine()).isEqualTo(false);
    assertThat(Direction.LEFT.hasLine()).isEqualTo(false);
    assertThat(Direction.RIGHT.hasLine()).isEqualTo(true);
  }

  @Test
  public void rightDrawTest() {
    assertThat(Direction.RIGHT.draw()).isEqualTo("|-----");
  }

  @Test
  public void leftDrawTest() {
    assertThat(Direction.LEFT.draw()).isEqualTo("|     ");
  }

  @Test
  public void straightDrawTest() {
    assertThat(Direction.STRAIGHT.draw()).isEqualTo("|     ");
  }

  @Test
  public void moveRightTest() {
    int position = 3;
    assertThat(Direction.RIGHT.move(position)).isEqualTo(4);
  }

  @Test
  public void moveLeftTest() {
    int position = 3;
    assertThat(Direction.LEFT.move(position)).isEqualTo(2);
  }

  @Test
  public void moveStraightTest() {
    int position = 3;
    assertThat(Direction.STRAIGHT.move(position)).isEqualTo(3);
  }

}

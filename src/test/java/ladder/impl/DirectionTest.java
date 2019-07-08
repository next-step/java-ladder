package ladder.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class DirectionTest {

  @Test
  public void 생성테스트() {
    assertThat(Direction.STRAIGHT == Direction.STRAIGHT).isTrue();
    assertThat(Direction.LEFT == Direction.LEFT).isTrue();
    assertThat(Direction.RIGHT == Direction.RIGHT).isTrue();
  }

  @Test
  public void DIRECTION_STRAIGHT_test() {
    Position index = new Position(3);
    assertThat(Direction.STRAIGHT.move(index)).isEqualTo(new Position(3));
  }

  @Test
  public void DIRECTION_RIGHT_test() {
    Position index = new Position(3);
    assertThat(Direction.RIGHT.move(index)).isEqualTo(new Position(4));
  }

  @Test
  public void DIRECTION_LEFT_test() {
    Position index = new Position(3);
    assertThat(Direction.LEFT.move(index)).isEqualTo(new Position(2));
  }

  @Test
  public void first_direction은_STRAIGHT_혹은_RIGHT() {
    assertThat(Direction.first()).isIn(Direction.RIGHT, Direction.STRAIGHT);
  }

  @Test
  public void 연속으로_RIGHT가_올수없다() {
    assertThat(Direction.RIGHT.next()).isIn(Direction.STRAIGHT, Direction.LEFT);
  }

  @Test
  public void 마지막_direction은_LEFT혹은_STRAIGHT다() {
    assertThat(Direction.RIGHT.last()).isEqualTo(Direction.LEFT);
    assertThat(Direction.STRAIGHT.last()).isEqualTo(Direction.STRAIGHT);
  }

}
package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DirectionTest {

  @Test
  void 연속해서_true값을_가질_수_없음_검증() {
    assertThatThrownBy(() -> {
      Direction.of(true, true);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void 처음으로_시작하는_direction은_왼쪽이_false_검증() {
    Direction direction = Direction.first(true);
    assertThat(direction.left()).isFalse();
  }

  @Test
  void 마지막으로_끝나는_direction은_오른쪽이_false_검증() {
    Direction direction = Direction.last(true);
    assertThat(direction.current()).isFalse();
  }

  @Test
  void 왼쪽_방향으로_이동_검증() {
    MoveStatus movedStatus = Direction.of(true, false).move();
    assertThat(movedStatus).isEqualTo(MoveStatus.LEFT);
  }

  @Test
  void 오른쪽_방향으로_이동_검증() {
    MoveStatus movedStatus = Direction.of(false, true).move();
    assertThat(movedStatus).isEqualTo(MoveStatus.RIGHT);
  }

  @Test
  void 이동하지_않는_검증() {
    MoveStatus movedStatus = Direction.of(false, false).move();
    assertThat(movedStatus).isEqualTo(MoveStatus.NONE);
  }

}
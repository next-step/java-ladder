package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.*;

import ladder.domain.strategy.NextPointGenerationStrategy;
import ladder.domain.strategy.RandomPointGenerationStrategy;
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
    NextPointGenerationStrategy strategy = new RandomPointGenerationStrategy(){
      @Override
      public boolean nextBoolean(boolean prev) {
        return false;
      }
    };

    Direction direction = Direction.first(strategy);
    assertThat(direction.left()).isFalse();
  }

  @Test
  void 마지막으로_끝나는_direction은_오른쪽이_false_검증() {
    Direction direction = Direction.last(true);
    assertThat(direction.current()).isFalse();
  }

  @Test
  void 왼쪽_방향으로_이동_검증() {
    int movedStatus = Direction.of(true, false).move();
    assertThat(movedStatus).isEqualTo(MoveStatus.LEFT.value());
  }

  @Test
  void 오른쪽_방향으로_이동_검증() {
    int movedStatus = Direction.of(false, true).move();
    assertThat(movedStatus).isEqualTo(MoveStatus.RIGHT.value());
  }

  @Test
  void 이동하지_않는_경우_검증() {
    int movedStatus = Direction.of(false, false).move();
    assertThat(movedStatus).isEqualTo(MoveStatus.NONE.value());
  }

  @Test
  void 현재방향이_true라면_다음방향은_무조건_false_검증() {
    Direction nowDirection = Direction.of(false, true);
    Direction nextDirection = nowDirection.next(new RandomPointGenerationStrategy());
    assertThat(nextDirection.current()).isFalse();
  }

  @Test
  void 현재방향이_false라면_다음방향은_true_가능() {
    Direction nowDirection = Direction.of(true, false);
    NextPointGenerationStrategy strategy = new RandomPointGenerationStrategy(){
      @Override
      public boolean nextBoolean(boolean prev) {
        return true;
      }
    };

    Direction nextDirection = nowDirection.next(strategy);
    assertThat(nextDirection.current()).isTrue();
  }

  @Test
  void 현재방향이_false라면_다음방향은_false_가능() {
    Direction nowDirection = Direction.of(true, false);
    NextPointGenerationStrategy strategy = new RandomPointGenerationStrategy(){
      @Override
      public boolean nextBoolean(boolean prev) {
        return false;
      }
    };

    Direction nextDirection = nowDirection.next(strategy);
    assertThat(nextDirection.current()).isFalse();
  }


}
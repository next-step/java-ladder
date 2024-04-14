package ladder.domain;

import ladder.domain.movestrategy.NormalMoveStrategy;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.*;

public class SidesTest {
  @Test
  void 행의_첫_번쨰_요소_생성() {
    Sides sides = Sides.first(true);
    assertThat(sides.direction(new NormalMoveStrategy())).isEqualTo(Direction.RIGHT);
  }

  @Test
  void 기존_요소의_다음_요소_생성() {
    Sides sides = Sides.first(true).next(false);
    assertThat(sides.direction(new NormalMoveStrategy())).isEqualTo(Direction.LEFT);
  }

  @Test
  void 마지막_요소_생성() {
    Sides sides = Sides.first(false).last();
    assertThat(sides.direction(new NormalMoveStrategy())).isEqualTo(Direction.STRAIGHT);
  }

  @Test
  void 이동방향_반환() {
    Sides sides = Sides.first(false).next(false);
    assertThat(sides.direction(s -> Direction.values()[ThreadLocalRandom.current().nextInt(3)]))
            .isInstanceOf(Direction.class);
  }
}

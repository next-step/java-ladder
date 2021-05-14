package nextstep.laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

  @Test
  @DisplayName("of()를 통해서 Direction을 생성한다")
  void create() {
    Direction direction = Direction.of(true, false);
    assertEquals(direction, Direction.of(true, false));
  }

  @Test
  @DisplayName("first()를 통해서 첫번째 디렉션을 생성한다")
  public void first() {
    Direction direction = Direction.first(true);
    assertEquals(direction, Direction.of(false, true));
  }

  @Test
  @DisplayName("last()를 통해서 마지막 디렉션을 생성한다")
  public void last() {
    Direction direction = Direction.first(true).last();
    assertEquals(direction, Direction.of(true, false));
  }

  @Test
  @DisplayName("next()를 통해서 다음 Direction을 RandomValueGenerator를 통해 생성할 수 있다")
  public void next_no_parameter() {
    Direction direction = Direction.first(true).next();
    assertEquals(direction, Direction.of(true, false));
  }

  @Test
  @DisplayName("next(boolean nextRight)를 통해서 다음 Direction을 생성할 수 있다.")
  public void next_has_parameter() {
    Direction direction = Direction.first(false).next(true);
    assertEquals(direction, Direction.of(false, true));
  }
}
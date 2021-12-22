package nextstep.ladder;

import nextstep.ladder.domain.entity.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DirectionTest {

  @ParameterizedTest
  @CsvSource(value = {"true:false", "false:true"}, delimiter = ':')
  @DisplayName("direction 생성을 통해 왼쪽과 오른쪽 길을 생성한다.")
  void init(boolean left, boolean right) {
    Direction direction = Direction.of(left, right);
    assertEquals(direction.isLeft(), left);
    assertEquals(direction.isRight(), right);
  }

  @ParameterizedTest
  @CsvSource(value = {"true:true"}, delimiter = ':')
  @DisplayName("direction 생성시 양쪽 방향에 길이 있을 경우 에러가 발생한다.")
  void init_invalid(boolean left, boolean right) {
    assertThrows(IllegalStateException.class, () -> Direction.of(left, right));
  }


  @ParameterizedTest
  @CsvSource(value = {"true:false:true", "false:true:false"}, delimiter = ':')
  @DisplayName("next point의 방향을 생성할 시 prev의 오른쪽 방향을 next의 왼쪽 방향으로 지정하고 주어진 길의 유무를 오른쪽 방향으로 지정한다.")
  void next_true(boolean left, boolean right, boolean next) {
    Direction nextDir = Direction.of(left, right).next(next);
    assertEquals(nextDir.isLeft(), right);
    assertEquals(nextDir.isRight(), next);
  }

  @ParameterizedTest
  @CsvSource(value = {"false:false", "false:true"}, delimiter = ':')
  @DisplayName("0번 째 사다리는 왼편은 항상 다리가 없고 오른쪽의 방향은 다리의 유무를 정할 수 있다.")
  void first(boolean left, boolean right) {
    Direction first = Direction.first(right);
    assertEquals(first.isLeft(), left);
    assertEquals(first.isRight(), right);
  }

  @ParameterizedTest
  @CsvSource(value = {"true:true:false", "false:false:false"}, delimiter = ':')
  @DisplayName("마지막번째 사다리는 오른편은 항상 다리가 없고 왼편의 방향은 이전 번째의 오른쪽 사다리의 유무로 결정된다.")
  void last(boolean prev, boolean left, boolean right) {
    Direction last = Direction.first(prev).last();
    assertEquals(last.isLeft(), left);
    assertEquals(last.isRight(), right);
  }

}
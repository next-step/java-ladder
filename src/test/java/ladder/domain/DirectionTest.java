package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DirectionTest {

  private Direction canNextMoveDirection;
  private Direction cannotNextMoveDirection;

  @BeforeEach
  public void setUp() {
    canNextMoveDirection = Direction.firstDirectionOfPoint(() -> true);
    cannotNextMoveDirection = Direction.firstDirectionOfPoint(() -> false);
  }

  @Test
  @DisplayName("첫 포인트의 방향 반환 테스트")
  public void create_첫_방향() {
    assertAll(
            () -> assertThat(canNextMoveDirection.canMoveNext()).isTrue(),
            () -> assertThat(canNextMoveDirection.canMovePrevious()).isFalse(),
            () -> assertThat(cannotNextMoveDirection.canMovePrevious()).isFalse(),
            () -> assertThat(cannotNextMoveDirection.canMovePrevious()).isFalse()

    );
  }

  @Test
  @DisplayName("마지막 포인트의 방향 반환 테스트")
  public void create_마지막_방향() {
    assertAll(
            () -> assertThat(canNextMoveDirection.lastDirectionOfPoint().canMoveNext()).isFalse(),
            () -> assertThat(canNextMoveDirection.lastDirectionOfPoint().canMovePrevious()).isTrue(),
            () -> assertThat(cannotNextMoveDirection.lastDirectionOfPoint().canMoveNext()).isFalse(),
            () -> assertThat(cannotNextMoveDirection.lastDirectionOfPoint().canMovePrevious()).isFalse()
    );
  }

  @ParameterizedTest(name = "다음 포인트의 방향 반환 테스트")
  @MethodSource("nextDirection")
  public void create_다음_방향(Direction direction, boolean previousExpected, boolean nextExpected) {
    assertAll(
            () -> assertThat(direction.canMovePrevious()).isEqualTo(previousExpected),
            () -> assertThat(direction.canMoveNext()).isEqualTo(nextExpected)
    );
  }

  private static Stream<Arguments> nextDirection() {
    return Stream.of(
            Arguments.arguments(Direction.firstDirectionOfPoint(() -> true).nextDirectionOfPoint(() -> true), true, false),
            Arguments.arguments(Direction.firstDirectionOfPoint(() -> true).nextDirectionOfPoint(() -> false), true, false),
            Arguments.arguments(Direction.firstDirectionOfPoint(() -> false).nextDirectionOfPoint(() -> true), false, true),
            Arguments.arguments(Direction.firstDirectionOfPoint(() -> false).nextDirectionOfPoint(() -> false), false, false)
    );
  }
}

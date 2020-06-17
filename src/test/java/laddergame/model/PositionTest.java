package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PositionTest {

  @ParameterizedTest
  @MethodSource("providePositionWithLine")
  void movePositionsTest(Position position, boolean canMoveLeft, boolean canMoveRight,
      Position expected) {
    position.movePositions(canMoveLeft, canMoveRight);
    assertThat(position).isEqualTo(expected);
  }

  public static Stream<Arguments> providePositionWithLine() {
    return Stream.of(
        arguments(
            new Position(new NaturalNumber(0)),
            false,
            true,
            new Position(new NaturalNumber(1))
        ),
        arguments(
            new Position(new NaturalNumber(1)),
            true,
            false,
            new Position(new NaturalNumber(0))
        )
    );
  }

  @ParameterizedTest
  @MethodSource("providePositionForMoveLeft")
  void moveLeft(Position position, Position expected) {
    position.moveLeft();

    assertThat(position).isEqualTo(expected);
  }

  public static Stream<Arguments> providePositionForMoveLeft() {
    return Stream.of(
        arguments(
            new Position(new NaturalNumber(1)),
            new Position(new NaturalNumber(0))
        )
    );
  }

  @ParameterizedTest
  @MethodSource("provideWrongPositionForMoveLeft")
  void moveLeft_wrong(Position position) {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
      position.moveLeft();
    });
  }

  public static Stream<Arguments> provideWrongPositionForMoveLeft() {
    return Stream.of(
        arguments(
            new Position(new NaturalNumber(0))
        )
    );
  }

  @ParameterizedTest
  @MethodSource("providePositionForMoveRight")
  @DisplayName("왼쪽이동 실패")
  void moveRight(Position position, Position expected) {
    position.moveRight();

    assertThat(position).isEqualTo(expected);
  }

  public static Stream<Arguments> providePositionForMoveRight() {
    return Stream.of(
        arguments(
            new Position(new NaturalNumber(0)),
            new Position(new NaturalNumber(1))
        )
    );
  }
}
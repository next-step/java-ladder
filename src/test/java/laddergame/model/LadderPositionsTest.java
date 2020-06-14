package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderPositionsTest {

  @ParameterizedTest
  @MethodSource("providePositionsWithIndex")
  void getPositionByIndex(LadderPositions result, int index, Position expected) {
    assertThat(result.getPositionByIndex(index)).isEqualTo(expected);

  }

  public static Stream<Arguments> providePositionsWithIndex() {
    return Stream.of(
        arguments(
            new LadderPositions(Arrays.asList(
                new Position(new NaturalNumber(1)))
            ),
            0,
            new Position(new NaturalNumber(1))
        ),
        arguments(
            new LadderPositions(Arrays.asList(
                new Position(new NaturalNumber(1)),
                new Position(new NaturalNumber(3)),
                new Position(new NaturalNumber(2)))
            ),
            2,
            new Position(new NaturalNumber(2))
        )
    );
  }

  @ParameterizedTest
  @MethodSource("provideDuplicatedPositions")
  @DisplayName("LadderPositions 생성 시 positions 의 값이 겹치는 경우")
  void init_withDuplicatedPositions(List<Position> positions) {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
      new LadderPositions(positions);
    });

  }

  public static Stream<Arguments> provideDuplicatedPositions() {
    return Stream.of(
        arguments(Arrays.asList(
            new NaturalNumber(1),
            new NaturalNumber(1),
            new NaturalNumber(2))
        )
    );
  }
}
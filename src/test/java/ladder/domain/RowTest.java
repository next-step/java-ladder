package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class RowTest {
  @ParameterizedTest
  @MethodSource("provideWrongConstructorInput")
  void 연속된_line_있는_다리행_생성_불가(List<Boolean> input) {
    assertThatThrownBy(() -> Row.of(input, 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("잘못된 사다리 입력입니다.");
  }

  private static Stream<List<Boolean>> provideWrongConstructorInput() {
    return Stream.of(
            List.of(true, true, true),
            List.of(true, true, false),
            List.of(false, true, true)
    );
  }
  
  @ParameterizedTest
  @MethodSource("provideWrongConstructorInput2")
  void 입력_값으로_0_1_외에는_불가(int[] input) {
    assertThatThrownBy(() -> Row.of(input, 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("사다리 입력은 0, 1 값만 유효합니다.");
  }

  private static Stream<int[]> provideWrongConstructorInput2() {
    return Stream.of(
            new int[] { 2, 1, 0 },
            new int[] { -1, 2, 10 }
    );
  }

  @ParameterizedTest
  @MethodSource("provideRightConstructorInput")
  void 정상_다리_생성(List<Boolean> input) {
    Row.of(input, 0);
  }

  private static Stream<List<Boolean>> provideRightConstructorInput() {
    return Stream.of(
            List.of(false, false, false),
            List.of(false, false, true),
            List.of(false, true, false),
            List.of(true, false, false),
            List.of(true, false, true)
    );
  }

  @Test
  void generator_로_생성() {
    Row row = Row.fromGenerator((size, y) -> Row.of(new int[]{0, 1, 0, 1}, y), 4, 0);
    assertThat(row).isEqualTo(Row.of(List.of(false, true, false, true), 0));
  }

  @ParameterizedTest
  @MethodSource("provideWrongGeneratorInput")
  void 잘못된_generator_입력(int[] input1, Integer input2) {
    assertThatThrownBy(() -> Row.fromGenerator((size, y) -> Row.of(input1, y), input2, 0))
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("입력된 사다리 행(Row) 길이와 생성된 사다리 행 길이와 일치하지 않습니다.");
  }

  private static Stream<Arguments> provideWrongGeneratorInput() {
    return Stream.of(
            Arguments.arguments(new int[]{0, 1, 0, 1, 0}, 4),
            Arguments.arguments(new int[]{0, 1, 0, 1}, 2)
    );
  }
  
  @ParameterizedTest
  @MethodSource("provideSizeValidationTestParameters")
  void 사이즈_검증(List<Boolean> input, int size, boolean result) {
    Row row = Row.of(input, 0);
    assertThat(row.isNotSizeOf(size)).isEqualTo(result);
  }

  private static Stream<Arguments> provideSizeValidationTestParameters() {
    return Stream.of(
            Arguments.arguments(List.of(true, false, true), 3, false),
            Arguments.arguments(List.of(true, false, true, false), 3, true),
            Arguments.arguments(List.of(true, false), 3, true)
    );
  }

  @ParameterizedTest
  @MethodSource("provideNextPositionTestParameters")
  void 다음_위치_반환(Coordinates input, Coordinates result) {
    Row row = Row.of(new int[]{1, 0, 1, 0}, 0);
    assertThat(row.nextPosition(input)).isEqualTo(result);
  }

  private static Stream<Arguments> provideNextPositionTestParameters() {
    return Stream.of(
            Arguments.arguments(Coordinates.of(0, 0), Coordinates.of(1, 1)),
            Arguments.arguments(Coordinates.of(1, 0), Coordinates.of(0, 1)),
            Arguments.arguments(Coordinates.of(2, 0), Coordinates.of(3, 1)),
            Arguments.arguments(Coordinates.of(3, 0), Coordinates.of(2, 1)),
            Arguments.arguments(Coordinates.of(4, 0), Coordinates.of(4, 1))
    );
  }

  @ParameterizedTest
  @MethodSource("provideSizeTestParameters")
  void 크기_반환(int [] input, int result) {
    assertThat(Row.of(input, 0).size()).isEqualTo(result);
  }

  private static Stream<Arguments> provideSizeTestParameters() {
    return Stream.of(
            Arguments.arguments(new int[]{1, 0, 1, 0}, 4),
            Arguments.arguments(new int[]{1, 0, 1}, 3),
            Arguments.arguments(new int[]{1, 0, 1, 0, 1}, 5)
    );
  }

  @ParameterizedTest
  @MethodSource("provideValuesTestParameters")
  void 행_값_반환(int[] input, List<Boolean> result) {
    assertThat(Row.of(input, 0).values()).isEqualTo(result);
  }

  private static Stream<Arguments> provideValuesTestParameters() {
    return Stream.of(
            Arguments.arguments(new int[]{1, 0, 1, 0}, List.of(true, false, true, false)),
            Arguments.arguments(new int[]{1, 0, 1}, List.of(true, false, true)),
            Arguments.arguments(new int[]{1, 0, 1, 0, 1}, List.of(true, false, true, false, true))
    );
  }
}

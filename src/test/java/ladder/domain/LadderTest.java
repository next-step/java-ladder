package ladder.domain;

import ladder.rowgenerator.RowGenerator;
import ladder.rowgenerator.RowGeneratorRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {
  @ParameterizedTest
  @MethodSource("provideWrongConstructorInput")
  void 잘못된_사다리_입력_시_예외(int[][] input) {
    assertThatThrownBy(() -> Ladder.from(input))
            .isInstanceOf(IllegalArgumentException.class);
  }

  private static Stream<int[][]> provideWrongConstructorInput() {
    return Stream.of(
            new int[][]{
                    {1, 0, 1},
                    {0, 1, 0},
                    {-1, 0, 1}
            },
            new int[][]{
                    {1, 0, 1},
                    {0, 1, 0},
                    {1, 1, 1}
            },
            new int[][]{
                    {1, 1, 0},
                    {0, 1, 0},
                    {1, 0, 1}
            },
            new int[][]{
                    {2, 0, 1},
                    {0, 1, 0},
                    {1, 0, 1}
            },
            new int[][] {
                    {1, 0 ,1},
                    {0, 0, 0, 1}
            },
            new int[][] {
            }
    );
  }

  @ParameterizedTest
  @MethodSource("provideRightConstructorInput")
  void 정상_사다리_생성1(int[][] input) {
    Ladder.from(input);
  }

  private static Stream<int[][]> provideRightConstructorInput() {
    return Stream.of(
            new int[][]{
                    {1, 0, 0},
                    {0, 1, 0},
                    {0, 0, 1},
                    {1, 0, 1}
            },
            new int[][]{
                    {0, 0, 0},
                    {0, 1, 0},
                    {1, 0, 1}
            },
            new int[][]{
                    {1, 0, 1},
                    {0, 1, 0},
                    {0, 0, 1},
                    {1, 0, 0}
            }
    );
  }

  @ParameterizedTest
  @MethodSource("provideRightConstructorInput2")
  void 정상_사다리_생성2(List<Row> input) {
    Ladder.from(input);
  }

  private static Stream<List<Row>> provideRightConstructorInput2() {
    return Stream.of(
            List.of(
                    Row.of(new int[] {1, 0, 0}, 0),
                    Row.of(new int[] {0, 1, 0}, 1),
                    Row.of(new int[] {0, 0, 1}, 2),
                    Row.of(new int[] {1, 0, 1}, 3)
            ),
            List.of(
                    Row.of(new int[] {0, 0, 0}, 0),
                    Row.of(new int[] {0, 1, 0}, 1),
                    Row.of(new int[] {1, 0, 1}, 2)
            ),
            List.of(
                    Row.of(new int[] {1, 0, 1}, 0),
                    Row.of(new int[] {0, 1, 0}, 1),
                    Row.of(new int[] {0, 0, 1}, 2),
                    Row.of(new int[] {1, 0, 0}, 3)
            )
    );
  }

  @ParameterizedTest
  @MethodSource("provideRightConstructorInput3")
  void 정상_사다리_생성3(int height, int width, RowGenerator generator) {
    Ladder.of(height, width, generator);
  }

  private static Stream<Arguments> provideRightConstructorInput3() {
    return Stream.of(
            Arguments.arguments(3, 5, new RowGeneratorRandom()),
            Arguments.arguments(2, 3, (RowGenerator) (size, y) -> Row.of(new int[] {1, 0, 1}, y)),
            Arguments.arguments(2, 5, (RowGenerator) (size, y) -> Row.of(new int[] {1, 0, 1, 0, 1}, y))
    );
  }

  @Test
  void 행_목록_반환() {
    Ladder ladder = Ladder.from(
            new int[][]{
                    {1, 0, 1},
                    {0, 1, 0},
                    {0, 0, 1},
                    {1, 0, 0}
            }
    );
    assertThat(ladder.rows()).isEqualTo(
            List.of(
                    Row.of(List.of(true, false, true), 0),
                    Row.of(List.of(false, true, false), 1),
                    Row.of(List.of(false, false, true), 2),
                    Row.of(List.of(true, false, false), 3)
            )
    );
  }
}

package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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
            }
    );
  }

  @ParameterizedTest
  @MethodSource("provideRightConstructorInput")
  void 정상_사다리_생성(int[][] input) {
    Ladder.from(new int[][]{
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
    });
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
}

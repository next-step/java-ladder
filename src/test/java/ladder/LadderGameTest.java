package ladder;

import ladder.domain.Ladders;
import ladder.domain.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.*;

public class LadderGameTest {
  @ParameterizedTest
  @MethodSource("provideGamePlayTestParameters")
  void 사다리_게임_실행_테스트(int[][] input, Map<String, Prize> result) {
    LadderGame ladderGame = new LadderGame(
            List.of("Kim", "Lee", "Park", "Choi", "Heo"),
            Ladders.from(input),
            List.of("꽝", "꽝", "10000", "1000", "5000")
    );
    ladderGame.play();
    Assertions.assertThat(ladderGame.result()).isEqualTo(result);
  }

  private static Stream<Arguments> provideGamePlayTestParameters() {
    return Stream.of(
            arguments(new int[][]{
                    {1, 0, 1, 0},
                    {0, 1, 0, 1},
                    {1, 0, 1, 0},
                    {0, 1, 0, 1},
                    {1, 0, 1, 0}
            }, Map.of("Kim", new Prize("5000"),
                    "Lee", new Prize("1000"),
                    "Park", new Prize("10000"),
                    "Choi", new Prize("꽝"),
                    "Heo", new Prize("꽝"))),
            arguments(new int[][] {
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}
            }, Map.of("Kim", new Prize("꽝"),
                    "Lee", new Prize("꽝"),
                    "Park", new Prize("10000"),
                    "Choi", new Prize("1000"),
                    "Heo", new Prize("5000")))
    );
  }
}

package ladder;

import ladder.domain.Ladder;
import ladder.dto.PrizeDto;
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
  void 사다리_게임_실행_테스트(int[][] input, Map<String, PrizeDto> result) {
    LadderGame ladderGame = new LadderGame(
            List.of("Kim", "Lee", "Park", "Choi", "Heo"),
            Ladder.from(input),
            List.of("꽝", "꽝", "10000", "1000", "5000")
    );
    ladderGame.play();
    Assertions.assertThat(ladderGame.results()).isEqualTo(result);
  }

  private static Stream<Arguments> provideGamePlayTestParameters() {
    return Stream.of(
            arguments(new int[][]{
                    {1, 0, 1, 0},
                    {0, 1, 0, 1},
                    {1, 0, 1, 0},
                    {0, 1, 0, 1},
                    {1, 0, 1, 0}
            }, Map.of("Kim", new PrizeDto("5000"),
                    "Lee", new PrizeDto("1000"),
                    "Park", new PrizeDto("10000"),
                    "Choi", new PrizeDto("꽝"),
                    "Heo", new PrizeDto("꽝"))),
            arguments(new int[][] {
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}
            }, Map.of("Kim", new PrizeDto("꽝"),
                    "Lee", new PrizeDto("꽝"),
                    "Park", new PrizeDto("10000"),
                    "Choi", new PrizeDto("1000"),
                    "Heo", new PrizeDto("5000")))
    );
  }
}

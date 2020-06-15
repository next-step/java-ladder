package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderPositionsTest {

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


  @ParameterizedTest
  @MethodSource("providePositionsPlayersResultsWithExpected")
  @DisplayName("플레이어와 결과 매핑")
  void getMapOf(LadderPositions ladderPositions, Players players, String[] results,
      Map<Player, String> expected) {
    Map<Player, String> resultPositionsMap = ladderPositions
        .getMapOf(players, results);

    resultPositionsMap.keySet().forEach(
        player -> assertThat(resultPositionsMap.get(player)).isEqualTo(expected.get(player)));
  }

  public static Stream<Arguments> providePositionsPlayersResultsWithExpected() {
    return Stream.of(
        arguments(
            new LadderPositions(
                Arrays.asList(
                    new Position(new NaturalNumber(2)),
                    new Position(new NaturalNumber(0)),
                    new Position(new NaturalNumber(3)),
                    new Position(new NaturalNumber(1))
                )
            ),
            new Players(
                Arrays.asList(
                    new Player(new Name("test1")),
                    new Player(new Name("test2")),
                    new Player(new Name("test3")),
                    new Player(new Name("test4"))
                )
            ),
            "result1,result2,result3,result4".split((",")),
            new HashMap<Player, String>() {{
              put(new Player(new Name("test1")), "result3");
              put(new Player(new Name("test2")), "result1");
              put(new Player(new Name("test3")), "result4");
              put(new Player(new Name("test4")), "result2");
            }}
        )
    );
  }
}
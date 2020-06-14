package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderTest {

  @ParameterizedTest
  @MethodSource("heightAndNameStrArrProvider")
  void createByHeightAndNamesStrArr(PositiveNumber height, String namesStr) {
    String[] nameStrArr = namesStr.split(",");
    Players players = Players.createByNameStrArr(namesStr.split(","));

    Ladder ladder = Ladder.createByHeightAndCountOfPerson(height, players.getCountOfPerson());

    assertThat(ladder.getLines().size()).isEqualTo(height.getValue());

    for (Line line : ladder.getLines()) {
      assertThat(line.getPoints().size()).isEqualTo(nameStrArr.length);
    }
  }

  public static Stream<Arguments> heightAndNameStrArrProvider() {
    return Stream.of(
        arguments(
            new PositiveNumber(1),
            "test1, test2, test3, test4"
        ),
        arguments(
            new PositiveNumber(5),
            "test1, test2, test3, test4"
        ),
        arguments(
            new PositiveNumber(5),
            "test1, test2, test3, test4, test5, test6, test7"
        )
    );
  }

  //Player, Ladder, Result 넣고 초기화
  @ParameterizedTest
  @MethodSource("ladderWithResultPositionProvider")
  void ladder_초기화하면_결과저장(Ladder ladder, LadderPositions expected) {
    assertThat(ladder.getResultPositions()).isEqualTo(expected);

  }

  public static Stream<Arguments> ladderWithResultPositionProvider() {
    return Stream.of(
        arguments(
            new Ladder(
                Arrays.asList(
                    new Line(
                        Arrays.asList(
                            new Point(false),
                            new Point(false),
                            new Point(false),
                            new Point(false)
                        )
                    )
                )
            ),
            new LadderPositions(Arrays.asList(
                new Position(new NaturalNumber(0)),
                new Position(new NaturalNumber(1)),
                new Position(new NaturalNumber(2)),
                new Position(new NaturalNumber(3))
            ))
        ),
        arguments(
            new Ladder(
                Arrays.asList(
                    new Line(
                        Arrays.asList(
                            new Point(false),
                            new Point(false),
                            new Point(false),
                            new Point(false)
                        )
                    ),
                    new Line(
                        Arrays.asList(
                            new Point(false),
                            new Point(true),
                            new Point(false),
                            new Point(false)
                        )
                    ),
                    new Line(
                        Arrays.asList(
                            new Point(false),
                            new Point(false),
                            new Point(false),
                            new Point(false)
                        )
                    )
                )
            ),
            new LadderPositions(Arrays.asList(
                new Position(new NaturalNumber(1)),
                new Position(new NaturalNumber(0)),
                new Position(new NaturalNumber(2)),
                new Position(new NaturalNumber(3))
            ))
        ),
        arguments(
            new Ladder(
                Arrays.asList(
                    new Line(
                        Arrays.asList(
                            new Point(false),
                            new Point(false),
                            new Point(false),
                            new Point(true)
                        )
                    ),
                    new Line(
                        Arrays.asList(
                            new Point(false),
                            new Point(true),
                            new Point(false),
                            new Point(false)
                        )
                    ),
                    new Line(
                        Arrays.asList(
                            new Point(false),
                            new Point(false),
                            new Point(true),
                            new Point(false)
                        )
                    )
                )
            ),
            new LadderPositions(Arrays.asList(
                new Position(new NaturalNumber(2)),
                new Position(new NaturalNumber(0)),
                new Position(new NaturalNumber(3)),
                new Position(new NaturalNumber(1))
            ))
        )
    );
  }

  @ParameterizedTest
  @MethodSource("provideLadderPlayersResultsExpected")
  void getResultPositionsMapOf(Ladder ladder, Players players, String[] results,
      Map<Player, String> expected) {
    Map<Player, String> resultPositionsMap = ladder.getResultPositionsMapOf(players, results);

    resultPositionsMap.keySet().forEach(
        player -> assertThat(resultPositionsMap.get(player)).isEqualTo(expected.get(player)));
  }

  public static Stream<Arguments> provideLadderPlayersResultsExpected() {
    return Stream.of(
        arguments(
            new Ladder(
                Arrays.asList(
                    new Line(
                        Arrays.asList(
                            new Point(false),
                            new Point(false),
                            new Point(false),
                            new Point(true)
                        )
                    ),
                    new Line(
                        Arrays.asList(
                            new Point(false),
                            new Point(true),
                            new Point(false),
                            new Point(false)
                        )
                    ),
                    new Line(
                        Arrays.asList(
                            new Point(false),
                            new Point(false),
                            new Point(true),
                            new Point(false)
                        )
                    )
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
            new HashMap<Player, String>(){{
              put(new Player(new Name("test1")), "result3");
              put(new Player(new Name("test2")), "result1");
              put(new Player(new Name("test3")), "result4");
              put(new Player(new Name("test4")), "result2");
            }}
        )
    );
  }


}
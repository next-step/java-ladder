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

class LadderResultPositionsTest {

  @ParameterizedTest
  @MethodSource("provideDuplicatedPositions")
  @DisplayName("LadderPositions 생성 시 positions 의 값이 겹치는 경우")
  void init_withDuplicatedPositions(List<Position> positions) {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
      new LadderResultPositions(positions);
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
  @MethodSource("ladderWithResultPositionProvider")
  @DisplayName("사다리 결과 저장")
  void createByLadderWithCountOfPerson(Ladder ladder, LadderResultPositions expected) {
    PositiveNumber countOfPerson = new PositiveNumber(ladder.getLines().get(0).getPoints().size());

    assertThat(LadderResultPositions.createByLadderWithCountOfPerson(ladder, countOfPerson))
        .isEqualTo(expected);
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
            new LadderResultPositions(Arrays.asList(
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
            new LadderResultPositions(Arrays.asList(
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
            new LadderResultPositions(Arrays.asList(
                new Position(new NaturalNumber(2)),
                new Position(new NaturalNumber(0)),
                new Position(new NaturalNumber(3)),
                new Position(new NaturalNumber(1))
            ))
        )
    );
  }

  @ParameterizedTest
  @MethodSource("providePositionsPlayersResultsWithExpected")
  @DisplayName("플레이어와 결과 매핑")
  void getMapOf(LadderResultPositions ladderResultPositions, Names keys, Names values,
      Map<Name, String> expected) {
    Map<Name, Name> resultPositionsMap = ladderResultPositions
        .getMapOf(keys, values);

    resultPositionsMap.keySet().forEach(
        player -> assertThat(resultPositionsMap.get(player)).isEqualTo(expected.get(player)));
  }

  public static Stream<Arguments> providePositionsPlayersResultsWithExpected() {
    return Stream.of(
        arguments(
            new LadderResultPositions(
                Arrays.asList(
                    new Position(new NaturalNumber(2)),
                    new Position(new NaturalNumber(0)),
                    new Position(new NaturalNumber(3)),
                    new Position(new NaturalNumber(1))
                )
            ),
            new Names(
                Arrays.asList(
                    new Name("test1"),
                    new Name("test2"),
                    new Name("test3"),
                    new Name("test4")
                )
            ),
            new Names(
                Arrays.asList(
                    new Name("rslt1"),
                    new Name("rslt2"),
                    new Name("rslt3"),
                    new Name("rslt4")
                )
            ),
            new HashMap<Name, Name>() {{
              put(new Name("test1"), new Name("rslt3"));
              put(new Name("test2"), new Name("rslt1"));
              put(new Name("test3"), new Name("rslt4"));
              put(new Name("test4"), new Name("rslt2"));
            }}
        )
    );
  }
}
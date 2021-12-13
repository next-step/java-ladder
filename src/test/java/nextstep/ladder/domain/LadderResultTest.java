package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {
    private LadderResult ladderResult;
    /*
      setUp Lines
      A -> 1
      B -> 2
      C -> 6
      D -> 4
      E -> 3
      F -> 5

      A      B      C      D      E      F
      |------|      |------|      |      |
      |      |      |      |------|      |
      |------|      |------|      |------|
      1      2      3      4      5      6
       */
    @BeforeEach
    @DisplayName("Players Ladder Results로 LadderResults를 생성한다")
    void setUp() {
        List<Line> lineList = Arrays.asList(
                Line.from(
                        Arrays.asList(
                                Column.head(Boolean.TRUE),
                                Column.body(Boolean.TRUE, Boolean.FALSE),
                                Column.body(Boolean.FALSE, Boolean.TRUE),
                                Column.body(Boolean.TRUE, Boolean.FALSE),
                                Column.body(Boolean.FALSE, Boolean.FALSE),
                                Column.tail(Boolean.FALSE)
                        )
                ),
                Line.from(
                        Arrays.asList(
                                Column.head(Boolean.FALSE),
                                Column.body(Boolean.FALSE, Boolean.FALSE),
                                Column.body(Boolean.FALSE, Boolean.FALSE),
                                Column.body(Boolean.FALSE, Boolean.TRUE),
                                Column.body(Boolean.TRUE, Boolean.FALSE),
                                Column.tail(Boolean.FALSE)
                        )
                ),
                Line.from(
                        Arrays.asList(
                                Column.head(Boolean.TRUE),
                                Column.body(Boolean.TRUE, Boolean.FALSE),
                                Column.body(Boolean.FALSE, Boolean.TRUE),
                                Column.body(Boolean.TRUE, Boolean.FALSE),
                                Column.body(Boolean.FALSE, Boolean.TRUE),
                                Column.tail(Boolean.TRUE)
                        )
                )
        );
        Players players = Players.from(new String[] {"A", "B", "C", "D", "E", "F"});
        Results results = Results.from(new String[] {"1", "2", "3", "4", "5", "6"});
        Lines lines = Lines.from(lineList);
        Ladder ladder = Ladder.from(lines);
        ladderResult = LadderResult.from(players, ladder, results);
    }

    @ParameterizedTest
    @DisplayName("Player에 해당하는 Result를 리턴한다")
    @MethodSource
    void resultOfPlayer(Player player, Result expectedResult) {
        Result actualResult = ladderResult.resultOfPlayer(player);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> resultOfPlayer() {
        return Stream.of(
                Arguments.of(
                    Player.from("A"), Result.from("1")
                ),
                Arguments.of(
                    Player.from("B"), Result.from("2")
                ),
                Arguments.of(
                    Player.from("C"), Result.from("6")
                ),
                Arguments.of(
                    Player.from("D"), Result.from("4")
                ),
                Arguments.of(
                    Player.from("E"), Result.from("3")
                ),
                Arguments.of(
                    Player.from("F"), Result.from("5")
                )
        );
    }
}
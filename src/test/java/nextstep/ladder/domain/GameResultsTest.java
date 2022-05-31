package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;

import static nextstep.ladder.domain.LineTest.convertToPoints;
import static org.assertj.core.api.Assertions.assertThat;

class GameResultsTest {

    GameResults gameResults;

    /*
    * 0     1     2     3
    * |-----|     |-----|
    * |     |-----|     |
    * |-----|     |-----|
    * a     b     c     d
    * */
    @BeforeEach
    void before(){
        List<Player> players = List.of(new Player("0"), new Player("1")
                , new Player("2"), new Player("3"));

        List lines = List.of(
                new Line(convertToPoints(List.of(false, true, false, true, false))),
                new Line(convertToPoints(List.of(false, false, true, false, false))),
                new Line(convertToPoints(List.of(false, true, false, true, false)))
        );

        Ladder ladder = new Ladder(lines);

        List<LadderResult> ladderResults = List.of(new LadderResult("a"), new LadderResult("b"),
                new LadderResult("c"), new LadderResult("d"));

        gameResults = GameResults.of(players, ladderResults, ladder);
    }


    @ParameterizedTest
    @DisplayName("플레이어의 사다리 결과를 얻는다.")
    @CsvSource(value = {
            "0, d",
            "1, b",
            "2, c",
            "3, a"
    })
    void find_player_result(String name, String result){
        assertThat(gameResults.getResultByName(name)).isEqualTo(LadderResult.of(result));
    }
}
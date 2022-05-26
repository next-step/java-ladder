package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultsTest {

    GameResults gameResults;

    @BeforeEach
    void before(){
        List<Player> players = List.of(new Player("test0"), new Player("test1")
                , new Player("test2"), new Player("test3"));

        Ladder ladder = new Ladder(List.of(
                new Line(List.of(false, true, false, true, false)),
                new Line(List.of(false, false, true, false, false)),
                new Line(List.of(false, true, false, true, false))
        ));

        List<LadderResult> ladderResults = List.of(new LadderResult("a"), new LadderResult("b"),
                new LadderResult("c"), new LadderResult("d"));

        gameResults = GameResults.of(players, ladderResults, ladder);
    }


    @ParameterizedTest
    @DisplayName("플레이어의 사다리 결과를 얻는다.")
    @CsvSource(value = {
            "test0, d",
            "test1, b",
            "test2, c",
            "test3, a"
    })
    void find_player_result(String name, String result){
        assertThat(gameResults.getResultByName(name)).isEqualTo(LadderResult.of(result));
    }
}
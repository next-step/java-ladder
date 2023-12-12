package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import nextstep.ladder.test.TestRandomLineGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class ScoreCalculatorTest {

    private Players players;
    private Player crong;
    private Player poby;
    private Ladder ladder;

    @BeforeEach
    void init() {
        players = Players.from(List.of("poby", "crong"));
        poby = players.findPlayer("poby");
        crong = players.findPlayer("crong");
        ladder = Ladder.of(5, RowLineFactory.from(new TestRandomLineGenerator(), 2));
    }

    @DisplayName("Players와 Ladder를 이용해 ScoreCalculator를 생성")
    @Test
    void createWithPlayersAnsLadder() {
        assertThatNoException().isThrownBy(() -> ScoreCalculator.of(players, ladder));
    }

    @DisplayName("ScoreCalculator를 이용해 PlayersGameResult 생성합니다.")
    @Test
    void createPlayersGameResultWithScoreCalculator() {
        ScoreCalculator scoreCalculator = ScoreCalculator.of(players, ladder);

        PlayersGameResult playersGameResult = scoreCalculator.playersGameResult();
        assertThat(playersGameResult).isInstanceOf(PlayersGameResult.class);
    }

    @DisplayName("포비는 언제나 성공, 크롱은 언제나 실패 입니다.")
    @RepeatedTest(10)
    void scoreCalculatorCanCalcuatePlayersGameResult(){
        String success = "성공";
        String fail = "꽝";
        GameResult gameResult = GameResult.of(success + ", " + fail);

        ScoreCalculator scoreCalculator = ScoreCalculator.of(players, ladder);
        PlayersGameResult playersGameResult = scoreCalculator.playersGameResult();

        String resultByPoby = scoreCalculator.playersGameResult()
            .findResultByPlayer(poby, gameResult);
        String resultByCrong = scoreCalculator.playersGameResult()
            .findResultByPlayer(crong, gameResult);

        assertThat(resultByPoby).isEqualTo(success);
        assertThat(resultByCrong).isEqualTo(fail);

    }
}

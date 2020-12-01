package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderClimberTest {
    @Test
    @DisplayName("사디라 타는 객체 생성")
    void createLadderClimber() {
        Players players = Players.from("a,b,c");
        Lines lines = Lines.fromHeight(players.getSize(), 3, (point) -> true);
        LadderClimber ladderClimber = new LadderClimber(players, lines);
    }

    @Test
    @DisplayName("사다리 타기")
    void climb() {
        Players players = Players.from("a,b");
        Lines lines = Lines.fromHeight(players.getSize(), 2, (point) -> true);
        LadderClimber ladderClimber = new LadderClimber(players, lines);

        LineResult firstLineResult = LineResult.from(players.getSize(), "꽝,3000");
        LineResults lineResults = ladderClimber.climb(firstLineResult);

        LineResult secondLineResult = new LineResult(Arrays.asList(new Result("3000"), new Result("꽝")));
        LineResult thirdLineResult = new LineResult(Arrays.asList(new Result("꽝"), new Result("3000")));
        LineResults lineResultsExpected = new LineResults(Arrays.asList(firstLineResult, secondLineResult, thirdLineResult));
        assertThat(lineResults).isEqualTo(lineResultsExpected);
    }
}

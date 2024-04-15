package ladder.domain;

import ladder.fixture.Fixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ResultsTest {

    @Test
    @DisplayName("참여자의 사다리 실행 결과를 리턴한다.")
    void run_oneResult() {
        Players players = Fixture.make3Players();
        Results results = Fixture.make3Results();
        Lines lines = Fixture.makeValidLines();
        Player targetPlayer = players.getPlayerByNameOrNull("A");
        Result expect = new Result("2");
        Assertions.assertThat(results.playerResults(lines, players, targetPlayer).get(targetPlayer))
                .usingRecursiveComparison()
                .isEqualTo(expect);
    }

    @Test
    @DisplayName("전체 참여자의 사다리 실행 결과를 리턴한다.")
    void run_AllResult() {
        Players players = Fixture.make3Players();
        Results results = Fixture.make3Results();
        Lines lines = Fixture.makeValidLines();
        Player targetPlayer = players.getPlayerByNameOrNull("ALL");
        Assertions.assertThat(results.playerResults(lines, players, targetPlayer))
                .usingRecursiveComparison()
                .isEqualTo(Fixture.makePlayerResult());
    }

}
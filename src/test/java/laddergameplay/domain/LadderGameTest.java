package laddergameplay.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    @DisplayName("winningResult 반환")
    void makeWinningResult() {
        // given
        People people = new People(Arrays.asList("hwan,kook,hyun,sun".split(",")));
        Results results = new Results(Arrays.asList("3000,lose,2000,lose".split(",")));
        Ladder ladder = new Ladder(4, 5);
        LadderGame ladderGame = new LadderGame(ladder);

        // when
        WinningResult winningResult = ladderGame.makeWinningResult(people, results);

        // then
        assertThat(winningResult.findAll().containsKey(new Person("hwan"))).isTrue();
        assertThat(winningResult.findAll().containsKey(new Person("hwan2"))).isFalse();
        assertThat(winningResult.findAll().containsValue(new Result("3000"))).isTrue();
        assertThat(winningResult.findAll().containsValue(new Result("5000"))).isFalse();
    }
}

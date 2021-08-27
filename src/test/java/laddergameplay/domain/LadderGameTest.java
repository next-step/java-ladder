package laddergameplay.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    @DisplayName("winningResult 반환 사다리 true 1칸")
    void makeWinningResult_true_one_line() {
        // given
        People people = new People(Arrays.asList("hwan,kook".split(",")));
        Results results = new Results(Arrays.asList("3000,lose".split(",")));
        Ladder ladder = new Ladder(2, 1, () -> true);
        LadderGame ladderGame = new LadderGame(ladder);

        // when
        WinningResult winningResult = ladderGame.makeWinningResult(people, results);

        // then
        assertThat(winningResult.findBy(new Person("hwan"))).isEqualTo(new Result("lose"));
        assertThat(winningResult.findBy(new Person("kook"))).isEqualTo(new Result("3000"));
    }

    @Test
    @DisplayName("winningResult 반환 사다리 false 1칸")
    void makeWinningResult_false_one_line() {
        // given
        People people = new People(Arrays.asList("hwan,kook".split(",")));
        Results results = new Results(Arrays.asList("3000,lose".split(",")));
        Ladder ladder = new Ladder(2, 1, () -> false);
        LadderGame ladderGame = new LadderGame(ladder);

        // when
        WinningResult winningResult = ladderGame.makeWinningResult(people, results);

        // then
        assertThat(winningResult.findBy(new Person("hwan"))).isEqualTo(new Result("3000"));
        assertThat(winningResult.findBy(new Person("kook"))).isEqualTo(new Result("lose"));
    }
}

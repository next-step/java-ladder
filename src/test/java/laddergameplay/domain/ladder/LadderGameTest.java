package laddergameplay.domain.ladder;

import laddergameplay.domain.dto.WinningResult;
import laddergameplay.domain.data.Person;
import laddergameplay.domain.data.Result;
import laddergameplay.domain.datas.People;
import laddergameplay.domain.datas.Results;
import laddergameplay.strategy.RandomLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    @DisplayName("winningResult 반환 사다리 true 1칸")
    void makeWinningResult_true_one_line() {
        // given
        People people = new People(Arrays.asList("hwan,kook,hyun,bo".split(",")));
        Results results = new Results(Arrays.asList("3000,lose,2000,5000".split(",")), people);
        Ladder ladder = new Ladder(people.subtractNumberFromSize(1), 1, new RandomLineStrategy(){
            @Override
            protected boolean currentPoint() {
                return true;
            }
        });
        LadderGame ladderGame = new LadderGame(ladder);

        // when
        WinningResult winningResult = ladderGame.makeWinningResult(people, results);

        // then
        assertThat(winningResult.findBy(new Person("hwan"))).isEqualTo(new Result("lose"));
        assertThat(winningResult.findBy(new Person("kook"))).isEqualTo(new Result("3000"));
        assertThat(winningResult.findBy(new Person("hyun"))).isEqualTo(new Result("5000"));
        assertThat(winningResult.findBy(new Person("bo"))).isEqualTo(new Result("2000"));
    }

    @Test
    @DisplayName("winningResult 반환 사다리 false 1칸")
    void makeWinningResult_false_one_line() {
        // given
        People people = new People(Arrays.asList("hwan,kook,hyun,bo".split(",")));
        Results results = new Results(Arrays.asList("3000,lose,2000,5000".split(",")), people);
        Ladder ladder = new Ladder(people.subtractNumberFromSize(1), 1, () -> false);
        LadderGame ladderGame = new LadderGame(ladder);

        // when
        WinningResult winningResult = ladderGame.makeWinningResult(people, results);

        // then
        assertThat(winningResult.findBy(new Person("hwan"))).isEqualTo(new Result("3000"));
        assertThat(winningResult.findBy(new Person("kook"))).isEqualTo(new Result("lose"));
        assertThat(winningResult.findBy(new Person("hyun"))).isEqualTo(new Result("2000"));
        assertThat(winningResult.findBy(new Person("bo"))).isEqualTo(new Result("5000"));
    }
}

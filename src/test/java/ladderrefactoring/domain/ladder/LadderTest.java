package ladderrefactoring.domain.ladder;

import ladderrefactoring.domain.datas.People;
import ladderrefactoring.strategy.LineStrategy;
import ladderrefactoring.strategy.RandomLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("Ladder 생성")
    void create() {
        // given
        People people = new People(Arrays.asList("a,b,c,d,e".split(",")));
        int heightOfLadder = 5;
        LineStrategy lineStrategy = new RandomLineStrategy(){
            @Override
            protected boolean currentPoint() {
                return true;
            }
        };

        // when
        Ladder ladder = new Ladder(people.subtractNumberFromSize(1), heightOfLadder, lineStrategy);

        // then
        assertThat(ladder).isEqualTo(new Ladder(people.subtractNumberFromSize(1), heightOfLadder, lineStrategy));
    }

    @Test
    @DisplayName("Ladder result 연산")
    void result() {
        // given
        People people = new People(Arrays.asList("hwan,kook,hyun,bo".split(",")));
        Ladder ladder = new Ladder(people.subtractNumberFromSize(1), 1, new RandomLineStrategy(){
            @Override
            protected boolean currentPoint() {
                return true;
            }
        });

        // when
        List<Integer> winningResult = ladder.result();

        // then
        assertThat(winningResult).isEqualTo(Arrays.asList(1, 0, 3, 2));
    }

}

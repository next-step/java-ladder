package ladderrefactoring.domain.ladder;

import ladderrefactoring.domain.datas.People;
import ladderrefactoring.strategy.DirectionStrategy;
import ladderrefactoring.strategy.RandomDirectionStrategy;
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
        DirectionStrategy directionStrategy = new RandomDirectionStrategy(){
            @Override
            protected boolean currentPoint() {
                return true;
            }
        };

        // when
        Ladder ladder = new Ladder(people.subtractNumberFromSize(1), heightOfLadder, directionStrategy);

        // then
        assertThat(ladder).isEqualTo(new Ladder(people.subtractNumberFromSize(1), heightOfLadder, directionStrategy));
    }

    @Test
    @DisplayName("Ladder result 연산")
    void result() {
        // given
        Ladder ladder = new Ladder(3, 1, new RandomDirectionStrategy(){
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

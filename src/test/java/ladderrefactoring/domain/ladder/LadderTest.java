package ladderrefactoring.domain.ladder;

import ladderrefactoring.strategy.DirectionStrategy;
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
        int widthOfLadder = 5;
        int heightOfLadder = 5;
        DirectionStrategy directionStrategy = () -> false;

        // when
        Ladder ladder = new Ladder(widthOfLadder, heightOfLadder, directionStrategy);

        // then
        assertThat(ladder).isEqualTo(new Ladder(widthOfLadder, heightOfLadder, directionStrategy));
    }

    @Test
    @DisplayName("Ladder result 연산")
    void result() {
        // given
        Ladder ladder = new Ladder(4, 1, () -> true);

        // when
        List<Integer> winningResult = ladder.result();

        // then
        assertThat(winningResult).isEqualTo(Arrays.asList(1, 0, 3, 2));
    }

}

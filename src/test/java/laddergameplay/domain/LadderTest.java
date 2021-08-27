package laddergameplay.domain;

import laddergameplay.strategy.LineStrategy;
import laddergameplay.strategy.RandomLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("Ladder 생성")
    void create() {
        // given
        int countOfPeople = 4;
        int heightOfLadder = 5;
        LineStrategy lineStrategy = new RandomLineStrategy();

        // when
        Ladder ladder = new Ladder(countOfPeople, heightOfLadder, lineStrategy);

        // then
        assertThat(ladder.getLadder().size()).isEqualTo(heightOfLadder);
        assertThat(ladder.getLadder().get(0)).isInstanceOf(Line.class);
    }
}

package laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @Test
    void create() {
        // given
        int countOfPeople = 4;
        int heightOfLadder = 5;

        // when
        Ladder ladder = new Ladder(countOfPeople, heightOfLadder);

        // then
        assertThat(ladder.height()).isEqualTo(heightOfLadder);
    }

}

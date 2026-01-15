package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void create_ladder() {
        Ladder ladder = new Ladder(3, 5);
        assertThat(ladder.getValues()).hasSize(3);
    }

    @Test
    void create_ladder_check_strategy() {
        int height = 4;
        int countOfPerson = 5;
        LineStrategy strategy = () -> true;

        Ladder ladder = new Ladder(height, countOfPerson, strategy);

        assertThat(ladder.getValues()).allSatisfy(line -> {
            assertThat(line.getPoints()).containsExactly(true, false, true, false);
        });

    }
}
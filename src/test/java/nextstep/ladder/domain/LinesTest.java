package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @Test
    void create_ladder() {
        Lines lines = new Lines(3, 5);
        assertThat(lines.getValues()).hasSize(3);
    }

    @Test
    void create_ladder_check_strategy() {
        int height = 4;
        int countOfPerson = 5;
        LineStrategy strategy = () -> true;

        Lines lines = new Lines(height, countOfPerson, strategy);

        assertThat(lines.getValues()).allSatisfy(line -> {
            assertThat(line.getPoints()).containsExactly(true, false, true, false);
        });

    }
}
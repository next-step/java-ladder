package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void create() {
        Ladder ladder = new Ladder(5);
        assertThat(ladder.getLines()).hasSize(5);
        ladder.getLines().forEach(line -> {
            assertThat(line.getPoints()).hasSize(3);
        });
        Ladder ladder2 = new Ladder(8);
        assertThat(ladder2.getLines()).hasSize(8);
        ladder2.getLines().forEach(line -> {
            assertThat(line.getPoints()).hasSize(5);
        });
    }

}

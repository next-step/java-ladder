package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderTest {

    @Test
    void create() {
        Ladder ladder = new Ladder(Arrays.asList(
            new Line(5, () -> true),
            new Line(5, () -> true),
            new Line(5, () -> true)
        ));
        assertThat(ladder.getLines().size()).isEqualTo(3);
    }
}

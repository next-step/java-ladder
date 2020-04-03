package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void ladder() {
        Ladder ladder = new Ladder(Arrays.asList(new Line(Arrays.asList(true, false, true, false))));

        assertThat(ladder.getLines()).hasSize(1);
        assertThat(ladder.getLines().get(0).getPoints()).hasSize(4);
    }
}

package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void createRandomLadder() {
        Ladder ladder = new Ladder(4, 5);
        assertThat(ladder.height()).isEqualTo(4);
    }

    @Test
    void manualLadder() {
        Ladder ladder = new Ladder(Arrays.asList(
                Row.createManual(Arrays.asList(false, false, true)),
                Row.createManual(Arrays.asList(false, true, false)),
                Row.createManual(Arrays.asList(true, false, true))
        ));
        assertThat(ladder.move(1)).isEqualTo(3);
    }
}

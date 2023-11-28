package ladder.domain.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void add() {
        Ladder ladder = new Ladder();
        ladder.add(new Line("|-| |"));
        assertThat(ladder.lines()).hasSize(1);
    }
}

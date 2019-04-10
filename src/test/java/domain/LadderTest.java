package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    public void 길이x높이의_사다리를_생성한다() {
        Ladder ladder = new Ladder(3, 5);
        assertThat(ladder.getLines()).hasSize(5);
    }
}

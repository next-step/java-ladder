package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    public void Ladder_생성() {
        Ladder ladder = new Ladder(4, 5);
        assertThat(ladder.getLines().size()).isEqualTo(5);
    }
}
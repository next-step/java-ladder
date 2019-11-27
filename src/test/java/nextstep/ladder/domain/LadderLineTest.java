package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {

    @Test
    public void move() {
        LadderLine line = new LadderLine(3);
        assertThat(line.move(0)).isNotEqualTo(line.move(1)).isNotEqualTo(line.move(2));
    }
}

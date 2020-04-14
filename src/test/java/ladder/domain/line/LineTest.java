package ladder.domain.line;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void drawMarkTest() {
        assertThat(Line.createByNumber(0).draw()).isEqualTo("|");
        assertThat(Line.createByNumber(1).draw()).isEqualTo("-----|");
    }

    @Test
    void ofLadderTest() {
        assertThat(Line.ofLadder(0)).isEqualTo("|");
        assertThat(Line.ofLadder(1)).isEqualTo("-----|");
    }
}
